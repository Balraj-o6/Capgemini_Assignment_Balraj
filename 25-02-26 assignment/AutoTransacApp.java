package practice;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

interface IValidate{
	public boolean isAuthenticated(String userId,String userPass); 
}

class Game {

    private String gameName;
    private String authorName;
    private float price;

    // default constructor
    public Game() {}

    // parameterized constructor
    public Game(String gameName, String authorName, float price) {
        this.gameName = gameName;
        this.authorName = authorName;
        this.price = price;
    }

    // getters and setters
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game [gameName=" + gameName +
                ", authorName=" + authorName +
                ", price=" + price + "]";
    }
}

class GameService {

    static ArrayList<Game> games = new ArrayList<>();

    
    public GameService() {

        if (games.isEmpty()) {
            games.add(new Game("SnowBird", "Danny", 300));
            games.add(new Game("FreshFood", "Ram", 450));
            games.add(new Game("Batsman", "Kate", 400));
            games.add(new Game("Pokiman", "Steeve", 600));
            games.add(new Game("YammyTommy", "Narayan", 350));
        }
    }

    // view all games
    public List<Game> viewAll() {
        return games;
    }

    // search by author
    public String authorSearch(String author) {
        
        for(Game game:games) {
        	if(author.equals(game.getAuthorName())) {
        		return game.getGameName();
        	}
        }
        return "NOT FOUND";
    }
}

	
class User implements IValidate{ 
 
     private String userid;
     private String password;
     
     public User() {}
     HashMap<String,String> u = new HashMap<>();
    
    void addUser(String userid,String password) {  
        //-   this method is used to initialize user.
    		this.userid = userid;
    		this.password = password;
    		if(!isAuthenticated(userid, password)) {
    			if(!userid.equals("")) {
    				u.put(userid, password);
    				System.out.println("added successfully");
    			}
    			else {
    				System.out.println("Invalid input");
    			}
    		}
    		else {
    			System.out.println("User already exists");
    		}
    }

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    public String toString() {
    		return "User [userid: "+userid+"]";
    }

	@Override
	public boolean isAuthenticated(String userId, String userPass) {
		return userId != null  && userPass != null && u.containsKey(userId);
	}
}

public class AutoTransacApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        User user = new User();
        GameService service = new GameService();

        int choice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1) RegisterUser");
            System.out.println("2) ViewGames");
            System.out.println("3) searchByName");
            System.out.println("4) Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter userid: ");
                    String uid = sc.nextLine();

                    System.out.print("Enter password: ");
                    String pwd = sc.nextLine();

                    user.addUser(uid, pwd);
                    break;

                case 2:
                    List<Game> list = service.viewAll();
                    list.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();

                    String result = service.authorSearch(author);
                    System.out.println(result);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
	}
}
