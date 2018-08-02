package userInputGroup;

import java.util.Scanner;


public class UserInput {
	
	//String vars are listen in order that they appears in the class.
	String userNeed,groupFilter, transactionFilterType, typeId, SSN, CCN, branchState, transactionType, 
		zip, month, year, firstName, middleName, lastName, aptNo, 
		streetName, city, state, country, phoneNumber, email;
	Scanner s = new Scanner(System.in);
	//userN is used to get out of a loop that validate correct user input. 0 stays in loop !=0 jumps out of loop (use 1)
	int userN = 0;
	
	//Each var have two methods a set and get which are separated by one lines.
	//Vars are separate by two lines e.g getUserNeed() \n\n setGroupFilter.
	
		//User set to either modify or search for the user need
		public void setUserNeed() {
			System.out.println("What would you like to do?\n"
				+"MODIFY: To either modify an entry\n"
				+"ADD: To add entry\n"
				+"SEARCH: To seach for an entry");
		do { userN = 0;
			userNeed = s.next().toLowerCase();
			if (0 == userNeed.compareToIgnoreCase("MODIFY")) {userN =1;}
			else if (0 == userNeed.compareToIgnoreCase("ADD")) {userN =1;}
			else if (0 == userNeed.compareToIgnoreCase("SEARCH")) {userN =1;}
			else {
				System.out.println("Invalid input please type 'MODIFY', 'ADD' or 'SEARCH'");
				}
			}while (userN ==0);
		}
	
	//get the need of the user
		public String getUserNeed() {
			return userNeed;
		}
	
		//User set Transaction Filter Type to search for
		public void setTransactionFilterType() {
			System.out.println("How would you like to group the transaction?\n"
								+"ZIP: To search a transaction by Zip during a month and year\n"
								+"BRANCH: To search by Branch State (ST)\n"
								+"TYPE: To seach for specific Type of transaction");
			do { userN = 0;
				transactionFilterType = s.next().toLowerCase();
				if (0 == transactionFilterType.compareToIgnoreCase("zip")) {userN =1;}
				else if (0 == transactionFilterType.compareToIgnoreCase("branch")) {userN =1;}
				else if (0 == transactionFilterType.compareToIgnoreCase("type")) {userN =1;}
				else {
					System.out.println("Invalid input please type 'ZIP', 'BRANCH' or 'TYPE'");
						}
				}while (userN ==0);
			}
			
			//get the Transaction Filter Type of the user
				public String getTransactionFilterType() {
					return transactionFilterType;
				}
		
				
		//User set which filter Transaction or Customer They would like to use
		public void setGroupFilter() {
			System.out.println("What would you like to filter by? TRANSACTION or CUSTOMER");
			do { userN = 0;
				groupFilter = s.next().toLowerCase();
				if (0 == groupFilter.compareToIgnoreCase("transaction")) {userN =1;}
				else if (0 == groupFilter.compareToIgnoreCase("customer")) {userN =1;}
				else {
					System.out.println("Invalid input please type 'TRANSACTION' or 'CUSTOMER'");
					}
				}while (userN ==0);
			}
	
		//Gets User choice for filter.
		public String getGroupFilter() {
			return groupFilter;
		}
	
		
		// User decides to use SSN or CCN
		public void setTypeID() {
			System.out.println("Would like to search by SSN or CCN?");
			do { userN = 0;
				typeId = s.next().toLowerCase();
				if (0 == typeId.compareToIgnoreCase("ssn")) {userN =1;}
				else if (0 == typeId.compareToIgnoreCase("ccn")) {userN =1;}
				else {
					System.out.println("Invalid input please type 'SSN' or 'CCN'");
					}
			}while (userN ==0);
		}
		
		//Return User pick for SSN or CCN
		public String getTypeId() {
			return typeId;
		}
		
		
		//Get Social Security Number
		public void setSSN() {
			System.out.println("What is the customer's SSN?");
			do{ userN = 0;
				SSN = s.next();
				if(SSN.matches("[0-9]+") == true && SSN.length() == 9) {
					userN = 1;
					}
				else {
					System.out.println("Invalid input please input a SSN of only numbers that is 9 digits long");
					}
				}while (userN == 0);
			}
		
		//Return Social Security Number
		public String getSSN() {
			return SSN;
			}
		
		
				//Set Credit Card Number
		public void setCCN() {
			System.out.println("What is the customer's CCN?");
			do{ userN = 0;
				CCN = s.next();
				if(CCN.length() == 16) {
					userN = 1;
					}
				else {
					System.out.println("Invalid input please input a CCN of only numbers that is 16 digits long");
					}
				}while (userN == 0);
			}
		
		//Return Credit Card Number
		public String getCCN() {
			return CCN;
			}
		
		
		//User set Branch's State to search
		public void setBranchState() {
			System.out.println("What is the Branch's State (ST) would you like to use?");
			do{ userN = 0;
				branchState = s.next();
				if(branchState.matches("[a-zA-Z]+") == true && branchState.length() < 31) {
					userN = 1;
					}
				else {
					System.out.println("Invalid input please input a State name with only letters");
					}
				}while (userN == 0);
			}
					 
		//Return user Branch State
		public String getBranchState() {
			return branchState;
			}

				
		//User set Transaction type to search by
		public void setTransactionType() {
			System.out.println("What type would you like to filter by?\n"
								+ "ZIP: to search by Zip code\n"
								+"BRANCH: to search by Branch\n"
								+"TRANSACTION: to search by Transaction type");
			do{ userN = 0;
				transactionType = s.next(); 
				if(transactionType.matches("[a-zA-Z]+") == true  && transactionType.length() < 31) {
					userN = 1;
					}
				else {
					System.out.println("Invalid input please input a Type with only letters and less than 30 characters");
					}
				}while (userN == 0);
			}

		// Return user Transaction type
		public String getTransactionType() {
			return transactionType;
			}
				
				
		//user input for zip
		public void setZip() {
			System.out.println("What is the zip?");
			do{ userN = 0;
				zip = s.next();
				if(zip.matches("[0-9]+") == true  && zip.length() <= 7) {
					userN = 1;
					}
				else {
					System.out.println("Invalid input please input a Zip wit at most 7 numbers");
					}
				}while (userN == 0);
			}
				
		//Return user zip for search
		public String getZip(){
			return zip;
			}
				
				
		//User input for month
		public void setMonth() {
			System.out.println("What is the month?");
			do{ userN = 0;
				month = s.next();
				if(month.matches("[0-9]+") == true  && month.length() == 2 || month.length() == 1) {
					userN = 1;
					}
				else {
					System.out.println("Invalid input please input the Month number 0-12");
					}
				}while (userN == 0);
			}
				
		//Return user Month for search
		public String getMonth() {
				return month;
				}
				
				
		//User set year for search
		public void setYear() {
			System.out.println("What year would you like to ues?");
			do{ userN = 0;
				year = s.next();
				if(year.matches("[0-9]+") == true  && year.length() == 4) {
					userN = 1;
					}
				else {
					System.out.println("Invalid input please input the Year as 'yyyy'");
					}
				}while (userN == 0);
			}
				
		//Return set year for search
		public String getYear() {
			return year;
			}
				
		
		//user set first name
		public void setFirstName() {
			System.out.println("What is the customer's first name?");
			do{ userN = 0;
				firstName = s.next();
				if(firstName.length() <= 40) {
					userN = 1;
				}
				else {
					System.out.println("Invalid input please input the customer's first name with only 40 or less letters");
					}
				}while (userN == 0);
			}
				
		//Return First Name
		public String getFirstName() {
			return firstName;
			}
				
				
		//User set middle name
		public void setMiddleName() {
			System.out.println("What is the customer's middle name?");
			do{ userN = 0;
				middleName = s.next();
				if(middleName.length() <= 40) {userN = 1;}
				else {
					System.out.println("Invalid input please input the customer's middle name with only 40 or less character");
					}
				}while (userN == 0);
			}
				
		//Return middle name
		public String getMiddleName() {
			return middleName;
			}
					
					
		//User set Last name
		public void setLastName() {
			System.out.println("What is the customer's last name?");
			do{ userN = 0;
				lastName = s.next();
				if(lastName.length() <= 40) {
					userN = 1;
					}
				else {
					System.out.println("Invalid input please input the customer's last name with only 40 or less character");
					}
				}while (userN == 0);
			}
				
		//Return Last Name
		public String getLastName() {
			return lastName;
			}
		
					
		//User set Apt No to search
		public void setAptNo() {
			System.out.println("What is the Apt No?");
			do{ userN = 0;
				aptNo = s.next();
				if(aptNo.length() < 7) {userN = 1;}
				else {
					System.out.println("Invalid input please input a Apt No name with only letters");
					}
				}while (userN == 0);
			}
						 
		//Return user Apt No
		public String getAptNo() {
			return aptNo;
			}
					
					
		//User set Street Name
		public void setStreetName() {
			System.out.println("What is the customer's street name?");
			do{ userN = 0;
				streetName = s.next();
				if(streetName.length() <= 30) {userN = 1;}
				else {
					System.out.println("Invalid input please input the customer's street name with only 30 or less character");
					}
				}while (userN == 0);
			}
				
		//Return Street Name
		public String getStreetName() {
			return streetName;
			}
			
		//User set City
		public void setCity() {
			System.out.println("What is the customer's city?");
			do{ userN = 0;
				city = s.next();
				if(city.length() <= 30) {userN = 1;}
				else {
					System.out.println("Invalid input please input the customer's city name with only 30 or less character");
					}
				}while (userN == 0);
			}
				
		//Return City
		public String getCity() {
			return city;
			}
				
				
		//User state City
		public void setState() {
			System.out.println("What is the customer's state?");
			do{ userN = 0;
				state = s.next().toUpperCase();
				if(state.length() <= 30) {userN = 1;}
				else {
					System.out.println("Invalid input please input the customer's State abbreviations as 'ST'");
					}
				}while (userN == 0);
			}
				
		//Return State
		public String getState() {
			return state;
			}
		//User set Country
		public void setCountry() {
			System.out.println("What is the customer's country?");
			do{ userN = 0;
			country = s.next();
			if(country.length() <= 30) {userN = 1;}
			else {
				System.out.println("Invalid input please input the customer's country name with only 30 or less character");
					}
				}while (userN == 0);
			}
				
		//Return Country
		public String getCountry() {
			return country;
			}
				
		//User set Phone number
		public void setphoneNumber() {
			System.out.println("What is the customer's phone number?");
			do{ userN = 0;
				phoneNumber = s.next();
				if(phoneNumber.matches("[0-9]+") && phoneNumber.length() == 9) {userN = 1;}
				else {
					System.out.println("Invalid input please input the customer's phone Number with 10 numbers");
						}
					}while (userN == 0);
			}
				
		//Return phone Number
		public String getphoneNumber() {
			return phoneNumber;
			}
		
		
		//User set Email
		public void setEmail() {
			System.out.println("What is the customer's email?");
			do{ userN = 0;
				email = s.next();
				if(email.length() <= 40) {userN = 1;}
				else {
						System.out.println("Invalid input please input the customer's email with only 40 or less character");
					}
				}while (userN == 0);
			}
				
		//Return Email
		public String getEmail() {
			return email;
			}
}
