package count;
import java.util.Scanner; // import the Scanner class 
public class Worknumber {
	public static void main(String[] args) {
		
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("급합니까? (Y/N)");
	    String response1 = scanner.nextLine();

	    if (response1.equalsIgnoreCase("Y")) {
	        System.out.println("중요합니까? (Y/N)");
	        String response2 = scanner.nextLine();

	        if (response2.equalsIgnoreCase("Y")) {
	            System.out.println("급하고 중요한 일 (1순위)");
	        } else if (response2.equalsIgnoreCase("N")) {
	            System.out.println("급하지만 중요하지 않은 일 (3순위)");
	        } else {
	            System.out.println("잘못된 입력입니다.");
	        }
	    } else if (response1.equalsIgnoreCase("N")) {
	        System.out.println("중요합니까? (Y/N)");
	        String response2 = scanner.nextLine();

	        if (response2.equalsIgnoreCase("Y")) {
	            System.out.println("급하지 않고 중요한 일(2순위) ");
	        } else if (response2.equalsIgnoreCase("N")) {
	            System.out.println("급하지도 않고 중요하지도 않은 일 (4순위)");
	        } else {
	            System.out.println("잘못된 입력입니다.");
	        }
	    } else {
	        System.out.println("잘못된 입력입니다.");
	    }

	    scanner.close();
			
			
		}

	}


