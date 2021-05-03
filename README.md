# My Wedding Planner

## A personal assistant to plan your dream wedding 


**My Wedding Planner** is a desktop application which will be a personal assistant to plan a couples dream wedding. 
While planning a wedding one of the biggest hassles & time-consuming tasks is to find vendors, look at their portfolios 
and then book initial chats with them. This app aims to make this process easier by providing a one-stop-shop platform 
for couples to research and book consultations with various different wedding vendors. 

Once a customer goes on to the platform, they can search for an intended vendor (ex: Decor) and then view the selection 
of Decor companies on the platform. Once they click on the vendor, they can view their portfolios (via Instagram) and 
then book consultations with the top vendors of their choice. The app could also be made more efficient by adding the 
capability for the user to view the vendor calendar to check whether they are accepting bookings on the day of the 
event. In the future, the app can have an added functionality which allows the user to create a profile and track their
progress as well as favoured vendors to successfully plan the whole wedding on the platform. Having a user profile 
could also help with creating customized timelines for the day of the event which will be automatically sent to the 
vendors that have been booked through the app. 

For Phase 1 of my project, I wanted to implement an admin view console where: 
- As an admin, I am able to create a new Vendor List 
- As an admin, I am able to update the newly created Vendor List with one or more vendor names
- As an admin, I am able to retrieve and read the vendor list 
- As an admin, I am able to delete a vendor name from the Vendor List 
- As an admin, I am able to save the vendor list 
- As an admin, I am able to load a saved vendor list

This project is of interest to me because I have worked as a wedding planner for 3 years and closely observed the 
industry. This is a pain point for majority of the weddings due to the saturation of various event-vendors these days. 
Given the customization and tailoring that each couple or family requires for their big day, having an (tech) assistant 
that takes care of these details could make the whole planning process more efficient. 

**How to run the app**
1.) Download or clone this repository to your computer 
2.) Right click and run the application from the GUI class (src > main > ui > GUI)

**Making the program robust**
To make the program more robust, I added three exceptions. 
1.) NameNotFoundException: added to the removeVendor() method in the VendorList class which will give an error if the 
                           name entered in the text field did not match any of the Vendor names in the existing list
                           
2.) ListNotFoundException: this exception is added to the updateVendorListButton() method in the MainJFrame class.
                           Previously, the user was able to add data to the main text area without initially creating 
                           a new list. Now, if the user tries to update a vendor, the program will alert the 
                           user that they need to create a new Vendor list first.
                           
3.) StringEmptyException:  this exception is added to the updateVendorListButton() and removeVendorListButtton() in the
                           MainJFrame Class. Previously, the user was able to click the add / remove button if the text
                           field was empty / blank. Now, if the user tries to update or delete a vendor with an empty 
                           text field, the program will alert the user that they cannot keep the textfield empty.
                           

**To-dos**
1.) Different Categories of Vendor Lists: instead of having a field for Category, I would design the program so that
the user is able to create different Vendor Lists (ex: Decor Vendor List, Florist Vendor List). I would then change the
Vendor class to have fields: name, address, URL(website). 

2.) MainJFrame has a lot of high coupling at the moment. With more time, I would create a separate class which creates 
and adds the actionlistener to the buttons 

3.) MainJFrame also consists of all the main text area GUI, I would create separate classes for the different panels 

