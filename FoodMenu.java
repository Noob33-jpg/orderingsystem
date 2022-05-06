//Group 6

import javax.swing.*;         // this are the java package used in this program
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FoodMenu implements ActionListener {


    // these are the frame and variables we used in this program.
    // 

    private static JFrame f1;
    private static JPanel p1;
    private static JLabel lhead,lname,lsname,lccno,linfo,lcusadd,lchMl,lmsp,lorder,lcType;
    private static JTextField tname,tsname,tccno;
    private static JTextArea tcDetails;
    private static JTable mealTable,orderTable;
    private static JScrollPane sp1,sp2;
    private static JSpinner msp,osp;
    private static JRadioButton yes,no;
    private static JButton addMeal,reset,remove,confirm;

    static DefaultTableModel model = new DefaultTableModel();
    static DefaultTableModel model1 = new DefaultTableModel();

    static double total= 0.0;


    // main method starts here!!
    public static void main(String[] args) {

        FoodMenu fm = new FoodMenu();

        //these are the Components of the Frames assigned here.
        
        f1 = new JFrame();
        f1.setTitle("Food Menu");  // in this line represent the title of the system
        f1.setResizable(false);

        ImageIcon image = new ImageIcon("icon.png");
        f1.setIconImage(image.getImage());  // image icon of the system
        
        p1 = new JPanel();
        p1.setLayout(null); // sets the layout of the container to the specified layout manager

        lhead = new JLabel("Food Menu");
        lhead.setFont(new Font("Sans", Font.BOLD, 35));
        lhead.setForeground(Color.black);
        lhead.setBounds(10,10,300,30);  //  this line represent as a header of the program.
        p1.add(lhead);


        // in this line we used JTextfield and JRadioButton to get the users input.

        lname = new JLabel("Customer Name");
        lname.setBounds(10,60,100,25);
        p1.add(lname);

        tname = new JTextField();
        tname.setBounds(150,60,200,25);
        p1.add(tname);

        lsname = new JLabel("Customer's Surname");
        lsname.setBounds(10,90,150,25);
        p1.add(lsname);

        tsname = new JTextField();
        tsname.setBounds(150,90,200,25);
        p1.add(tsname);

        lccno = new JLabel("Contact No");
        lccno.setBounds(10,120,100,25);
        p1.add(lccno);

        tccno = new JTextField();
        tccno.setBounds(150,120,200,25);
        p1.add(tccno);

        linfo = new JLabel("Do you order from us before ");
        linfo.setBounds(10,150,200,25);
        p1.add(linfo);

        yes = new JRadioButton("Yes");
        yes.setBounds(210,150,50,25);
        p1.add(yes);

        no = new JRadioButton("No");
        no.setBounds(270,150,50,25);
        p1.add(no);

        ButtonGroup G = new ButtonGroup();
        G.add(yes);
        G.add(no); // end here!


        lchMl = new JLabel("Choose Meals");  // choose meals title.
        lchMl.setFont(new Font("Sans", Font.BOLD, 24));
        lchMl.setForeground(Color.black);
        lchMl.setBounds(10,200,200,40);
        p1.add(lchMl);

        // heres the list of the available meals in our menu.
        // we use addRow object to list all the following meals

        mealTable = new JTable(model); // we used model variable for this item table
        model.addColumn("ITEM");
        model.addColumn("PRICE");
        mealTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        mealTable.getColumnModel().getColumn(1).setPreferredWidth(65); 
        mealTable.setBounds(0, 0, 365, 200); // column size width and height  
     
        model.addRow(new Object[]{"Fried noodles","40"});
        model.addRow(new Object[]{"Shawarma","55"});        
        model.addRow(new Object[]{"Shawarma rice","70"});
        model.addRow(new Object[]{"Takoyaki","30"});
        model.addRow(new Object[]{"Sisig","65"});
        model.addRow(new Object[]{"Chicken Wings","20"});
        model.addRow(new Object[]{"Milktea","65"});
        model.addRow(new Object[]{"Iced Coffee","45"});
        model.addRow(new Object[]{"Coca cola","15"});
        model.addRow(new Object[]{"Ice Cream","250"});
        model.addRow(new Object[]{"Water","25"});
        model.addRow(new Object[]{"Buko Juice","10"});
        model.addRow(new Object[]{"Tapsilog","65"});
        model.addRow(new Object[]{"Pares with Rice","45"});
        model.addRow(new Object[]{"Siomai Rice","25"});
        model.addRow(new Object[]{"Leche Flan","30"});
        model.addRow(new Object[]{"Chocolate Cake","75"});
        model.addRow(new Object[]{"Fries","30"});
        model.addRow(new Object[]{"Burger with Ham and Cheese","50"});
        model.addRow(new Object[]{"Ramen Noodles","30"});
        model.addRow(new Object[]{"Coffee Jelly","20"});
        model.addRow(new Object[]{"Porksilog","70"});

        sp1 = new JScrollPane(mealTable);
        sp1.setBounds(10, 250, 365, 200); // execute the mealtable
        p1.add(sp1);

        //  in this line, the system will ask the user for the meal quantity.

        lmsp = new JLabel("Quantity :");
        lmsp.setFont(new Font("Sans", Font.BOLD, 15));
        lmsp.setBounds(10,500,80,25);
        p1.add(lmsp);

        msp = new JSpinner();
        msp.setBounds(90,500,65,25);
        p1.add(msp);

        addMeal = new JButton("Add Meal");
        addMeal.setBounds(170,498,120,30);
        addMeal.setBackground(Color.green);
        addMeal.addActionListener(fm);
        p1.add(addMeal);  //  this is the addmeal button


        // order table starts here.
        // in this table shows all the meal you add

        lorder = new JLabel("Order Table");
        lorder.setFont(new Font("Sans", Font.BOLD, 24));  // title of the table
        lorder.setForeground(Color.black);
        lorder.setBounds(420,5,200,40);
        p1.add(lorder);

        orderTable = new JTable(model1); // we used model1 variable for this table
        model1.addColumn("ITEM");
        model1.addColumn("UNIT PRICE");
        model1.addColumn("QUANTITY");
        model1.addColumn("SUB TOTAL");
        orderTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        orderTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        orderTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        orderTable.getColumnModel().getColumn(3).setPreferredWidth(95);
        orderTable.setBounds(0, 0, 495, 100);  // size , width , height of the column we used

        sp2 = new JScrollPane(orderTable);
        sp2.setBounds(420, 45, 495, 260); // execute the order table 
        p1.add(sp2);

        reset = new JButton("Reset");
        reset.addActionListener(fm);    // reset button 
        reset.setBackground(Color.red);
        reset.setBounds(420,320,120,35);
        p1.add(reset);

        remove = new JButton("Remove");
        remove.addActionListener(fm);   // remove button
        remove.setBackground(Color.yellow);
        remove.setBounds(550,320,120,35);
        p1.add(remove);

        confirm = new JButton("Confirm Order");
        confirm.addActionListener(fm);  // confirm order button
        confirm.setBackground(Color.GREEN);
        confirm.setBounds(680,320,120,35);
        p1.add(confirm);

        lcType = new JLabel();
        lcType.setFont(new Font("Monospaced", Font.BOLD, 15));
        lcType.setForeground(Color.green);   
        lcType.setBounds(420,350,600,40);
        p1.add(lcType);

        tcDetails = new JTextArea();
        tcDetails.setBounds(420,390,490,150);
        p1.add(tcDetails);

        f1.add(p1);
        f1.setSize(940,600);   // frame size 
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // frame onclose method
        f1.setVisible(true);

    }
    // All the button functions using the abstract method of ActionListener Interface
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addMeal){
            int row = mealTable.getSelectedRow();
            String item =(String) model.getValueAt(row,0);
            String uprice = (String) model.getValueAt(row,1);
            String quantity = String.valueOf(msp.getValue());
            float subtotal = (Integer.parseInt(quantity)*Float.parseFloat(uprice));
            total+=subtotal;
            model1.addRow(new Object[]{item,uprice,quantity,String.valueOf(subtotal)});   // heres the addmeal button conditional statement
            // if the user push the addmeal button, the orderd meal will be redirect to the order table with the quantity and prize of the meal                                                                               

        }else if(e.getSource() == reset){
            total = 0.0;
            model1.setRowCount(0);  // heres the reset buton conditional statement ,if the user push the reset button it will automatically clear all the order history.
            lcType.setText("");
            tcDetails.setText(" ");

        }else if(e.getSource() == remove) {
            int row = orderTable.getSelectedRow();
            float subtotal = Float.parseFloat((String) model1.getValueAt(row, 3));
            model1.removeRow(row);
            total -= subtotal;
            System.out.println(total);  // remove button conditional statement
            // we used removeRow for this to remove the unwant order one by one in the order table.

        }else if (e.getSource()==confirm){ // confirm order conditional statement 

            if((tname.getText()).equals("")&&tsname.getText().equals("")&&tccno.getText().equals("")) {
                tcDetails.setText("Please enter your details first Thankyou.");
                tcDetails.setFont(new Font("Monospaced", Font.BOLD, 15));
                tcDetails.setForeground(Color.blue); // if the user push the confirm order button . this code will check the details like name surname and contct no.
                // if the following details is blank , the program will show the Please enter your details.
            }
            else {
            boolean oldCustomer = yes.isSelected();
            boolean newCustomer = no.isSelected();   // get the user selected button
            if(oldCustomer){
                lcType.setText("Thank you for choosing us again!");
            }else if(newCustomer){
                lcType.setText("I hope you will comeback again!");
            }
            else{
                lcType.setText("Select if you're old or new customer"); // heres the JRadiobutton conditional statement that allows the user choose old or new customer
            }

            // get the user input data

            String customerName = tname.getText();  
            char customerInitial =tsname.getText().toUpperCase().charAt(0); 
            // in this line the program will get the first letter of the customer surname.

            //Exception handling for getting only numbers as Contact Number
            try {
                long customerNo = Long.parseLong(tccno.getText());
                tcDetails.setFont(new Font("Sans", Font.BOLD, 15));
                tcDetails.setForeground(Color.black);tcDetails.setText(" Customer Name: "+customerInitial+"."+customerName +"\n\n"+
                " Customer Contact No: " + customerNo +"\n\n"+
                " Total Amount :"+total);  // the result if the user fiiled up all the details needed in this program

            }catch(NumberFormatException numberFormatException){
                tcDetails.setText("Please Re-enter your contact number with only numbers");  // this is the result shows in the system if the user input a string .
                
            }
            }
        }
    }
}

