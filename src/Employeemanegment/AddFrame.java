package Employeemanegment;

import java.util.*;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class AddFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField gender;
	private JTextField salary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Employee");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel.setBounds(143, 21, 124, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter ID:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(105, 80, 87, 25);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setBounds(202, 83, 86, 23);
		contentPane.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Enter Name:");
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(82, 125, 94, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Enter Gender:");
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(74, 172, 118, 25);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Enter Salay:");
		lblNewLabel_1_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(82, 223, 99, 25);
		contentPane.add(lblNewLabel_1_2_1);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(202, 128, 86, 23);
		contentPane.add(name);

		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(202, 175, 86, 23);
		contentPane.add(gender);

		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(202, 226, 86, 23);
		contentPane.add(salary);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement ps = null;
				String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";

				String url = "jdbc:mysql://localhost:3306/employee";
				String dpath = "com.mysql.cj.jdbc.Driver";
				String user = "root";
				String password = "Aditya@123";

				try {
					Class.forName(dpath);
					con = DriverManager.getConnection(url, user, password);
					ps = con.prepareStatement(sql);
					System.out.println("Enter id, name, gender, salary:");
					int inid = Integer.parseInt(id.getText());
					String inname = name.getText();
					String ingender = gender.getText();
					int insalary = Integer.parseInt(salary.getText());

					ps.setInt(1, inid);
					ps.setString(2, inname);
					ps.setString(3, ingender);
					ps.setInt(4, insalary);

					int nor = ps.executeUpdate();
					if (nor > 0) {
						JOptionPane.showMessageDialog(AddFrame.this, "Data Inserted Successfully!");
						id.setText("");
						name.setText("");
						gender.setText("");
						salary.setText("");
					}
					con.close();
					ps.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(105, 280, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomeFrame().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(238, 281, 89, 23);
		contentPane.add(btnBack);

	}

}
