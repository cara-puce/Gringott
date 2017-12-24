package serveur;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import client.app.IClient;
import client.app.Item;
import client.app.SellableItem;

public class ServerApp extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = -8168686161180269490L;

	DBManager dbManager;
	List<IClient> clients;
	List<Item> items;

	public ServerApp() throws RemoteException {
		this.dbManager = new DBManager();
		this.clients = new ArrayList<IClient>();
		//this.items = new ArrayList<Item>();
		this.items = this.dbManager.listItems();
	}

	@Override
	public void registerClient(IClient client) throws RemoteException {
		System.out.println("New client registered : " + client.getPseudo());
		this.clients.add(client);
		for (Item i : items) {
			client.addNewItem(i);
		}
	}

	@Override
	public void bid(Item item, double newPrice, IClient buyer) throws RemoteException {
		double price = item.getPrice() + newPrice;
		System.out.println("New bid from " + buyer.getPseudo() + " recorded for " + item.getName() + " at " + price);
		
		for (IClient c : clients) {
			c.update(item, price, buyer);
		}
	}

	@Override
	public List<Item> getItems() {
		return this.items;
	}

	@Override
	public void submit(Item item) throws RemoteException {
		System.out.println("New item registered : " + item);
		this.items.add(item);
		for (IClient c : clients) {
			c.addNewItem(item);
		}
	}

	public static void main(String[] args) {
		try {
			int port = 8090;
			LocateRegistry.createRegistry(port);
			IServer s = new ServerApp();
			Naming.bind("//localhost:" + port + "/enchere", s);

			while (true) {
				for(Item i : s.getItems()){
					Date localDate = new Date(System.currentTimeMillis());
					if (i.getTime().compareTo(localDate) < 0 && !i.isSold()){
						for (IClient c : s.getClients()){
							i.setSold(true);
							c.endSelling(i);
						}
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<IClient> getClients() throws RemoteException {
		return this.clients;
	}

	@Override
	public void logout(IClient client) throws RemoteException {
		this.clients.remove(client);
	}

}