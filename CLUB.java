import javax.swing.JOptionPane;
import java.io.*;               // for general file handling
public class CLUB
{
    // array of MEMBER objects
    private MEMBER memberList[];
    // number of members calculated after reading file
    int noOfMembers;

    // CLASSes to open, create, read/write, close files
    FILEREADCSV bmiFile;        // to read file from storage

    public CLUB()  throws IOException
    {
        // create file handler objects
        bmiFile = new FILEREADCSV();
    }

    // top level algorithm
    public void processMembers()  throws IOException
    {
        setUpMemberList();
        displayMembers();
        countOKbmi();
    }

    public void setUpMemberList() throws IOException
    {
        // First user message
        System.out.println("ScotFit Club: Membership BMI update\n");
        System.out.println("** Preparing to read data file.");

        // read file, fetch data as String array containing the rows
        String[] dataRows = bmiFile.readCSVtable();
        // calculate the number of member rows, skip headings
        noOfMembers = dataRows.length - 1;

        // update user with number of rows with membership details
        System.out.println("** " + noOfMembers + " rows read.\n\n");

        // prepare array for members
        memberList = new MEMBER[noOfMembers];
        // create member objects and copy data from source
        for  (int i = 0; i < noOfMembers; i++) {
            memberList[i] = new MEMBER();
            // adjust to skip headings
            memberList[i].readMemberDetails(dataRows[i+1]);
        }
    }

    public void displayMembers() {
        // Heading for the display
        System.out.println("A listing of all applicants for the next year\n");

        for  (int i = 0; i < noOfMembers; i++) {
            memberList[i].displayDetails();
        }

        // 2 blank line to separate this report from others.
        System.out.print("\n\n\n");
    }

    public void countOKbmi() throws IOException
    {
        System.out.println("A report of members within ideal BMI\n");

        // start the count
        int count = 0;
        // loop for each item : member
        for (int i = 0; i < noOfMembers; i++)
        {
            // decide if current item: member matches target: bmi
            if ((memberList[i].getBMI() > 18.5) && (memberList[i].getBMI() < 25) )
            {
                // add 1 to count: for OK bmi
                count = count +1;        
                // *display the details for the member
                memberList[i].displayDetails();
            }
        }
        // display the final count: bmi
        System.out.println("\n Total for OK BMI is : " + count);
        // A blank line to separate this report from others.
        System.out.println();
    }

    public static void main(String[] args)  throws IOException
    {
        CLUB myClub = new CLUB();
        myClub.processMembers();
    }
}
