
import java.util.ArrayList;
import java.util.Scanner;

public class Helper {

	/*
	 * readInputAndPrintOutPut method reads command line arguments and prints
	 * desired output in console. This program cannot proceed further if any of the
	 * command line arguments are not an integer. This program is designed in such a
	 * way that it will create first user as default and invites the random number
	 * of users within the range of minimum and maximum invitations including both
	 * minimum and maximum. If there is 0 invitation then the program will not
	 * create any user on that simulation day. The program outputs the user growth
	 * in breadth first manner.
	 */
	public static void readInputAndPrintOutPut() {

		Scanner input = new Scanner(System.in);

		int min_invites = 0;
		int max_invites = 0;
		int time = 0;

		try {
			System.out.print("Enter minimum invites: ");
			min_invites += Integer.parseInt(input.nextLine());

			System.out.print("Enter maximum invites: ");
			max_invites += Integer.parseInt(input.nextLine());

			System.out.print("Enter number of days: ");
			time += Integer.parseInt(input.nextLine());

			int day = 1;
			int createdIndex = 0;
			int inviterIndex = 0;

			ArrayList<User> users = new ArrayList<User>();

			users.add(new User());

			System.out.println("\nDay " + day + ": " + "#" + users.get(createdIndex).getUserId() + " created");

			while (time != 1) {
				day++;

				int randomInvitationNumber = generateRandomNumber(min_invites, max_invites);

				if (randomInvitationNumber != 0) {
					System.out.println("Day " + day + ": #" + users.get(inviterIndex).getUserId() + " is inviting "
							+ randomInvitationNumber + " friends");

					for (int invitation = 1; invitation <= randomInvitationNumber; invitation++) {
						users.add(new User());
						createdIndex++;
						System.out.println("Day " + day + ": " + "#" + users.get(createdIndex).getUserId()
								+ " created, which was invited by #" + users.get(inviterIndex).getUserId());
					}
					inviterIndex++;
					time--;

				} else {
					time--;
					System.out.println("Day " + day + ": No user was created because of " + randomInvitationNumber
							+ " invitation.");
				}

			}

			System.out.println("\nProgram executed gracefully \uD83D\uDE00");
			System.out.println("Good bye!");

		} catch (NumberFormatException nfe) {
			System.out.println(
					"\nPlease enter values in integer format only. Program ended!" + "\n\nStart your program again!");
		}

		input.close();

	}

	// generates random number between minimum and maximum values where minimum and
	// maximum both are inclusive
	public static int generateRandomNumber(int min, int max) {

		return (int) Math.round(((Math.random() * (max - min)) + min));
	}

}
