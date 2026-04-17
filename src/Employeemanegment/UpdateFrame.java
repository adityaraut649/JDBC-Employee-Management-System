package Employeemanegment;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class UpdateFrame extends JFrame {

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
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
	public UpdateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Update Employee ");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(186, 11, 147, 22);
		contentPane.add(lblNewLabel);

		id = new JTextField();
		id.setBounds(197, 57, 86, 20);
		contentPane.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Enter ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(113, 55, 74, 22);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Enter name:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(100, 103, 87, 22);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Enter Gender:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(83, 149, 104, 22);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Enter Salary:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(94, 195, 93, 22);
		contentPane.add(lblNewLabel_1_3);

		name = new JTextField();
		name.setBounds(197, 103, 86, 22);
		contentPane.add(name);
		name.setColumns(10);

		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(197, 151, 86, 22);
		contentPane.add(gender);

		salary = new JTextField();
		salary.setBounds(197, 197, 86, 20);
		contentPane.add(salary);
		salary.setColumns(10);

		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomeFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(194, 253, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnUpdataName = new JButton("Updata name");
		btnUpdataName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement ps = null;
				String sql = "Update employee set name = ? where id = ?";

				String url = "jdbc:mysql://localhost:3306/employee";
				String dpath = "com.mysql.cj.jdbc.Driver";
				String user = "root";
				String password = "Aditya@123";
				try {
					Class.forName(dpath);
					con = DriverManager.getConnection(url, user, password);
					ps = con.prepareStatement(sql);
					int inid = Integer.parseInt(id.getText());
					String inname = name.getText();

					ps.setInt(2, inid);
					ps.setString(1, inname);

					int nor = ps.executeUpdate();
					if (nor > 0) {
						JOptionPane.showMessageDialog(UpdateFrame.this, "Data updated Successfully!");
						id.setText("");
						name.setText("");
					}
					con.close();
					ps.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnUpdataName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdataName.setBackground(SystemColor.activeCaption);
		btnUpdataName.setBounds(346, 104, 117, 23);
		contentPane.add(btnUpdataName);

		JButton btnUpdateGender = new JButton("Update Gender");
		btnUpdateGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement ps = null;
				String sql = "Update employee set gender = ? where id = ?";

				String url = "jdbc:mysql://localhost:3306/employee";
				String dpath = "com.mysql.cj.jdbc.Driver";
				String user = "root";
				String password = "Aditya@123";
				try {
					Class.forName(dpath);
					con = DriverManager.getConnection(url, user, password);
					ps = con.prepareStatement(sql);
					int inid = Integer.parseInt(id.getText());
					String ingender = gender.getText();

					ps.setInt(2, inid);
					ps.setString(1, ingender);

					int nor = ps.executeUpdate();
					if (nor > 0) {
						JOptionPane.showMessageDialog(UpdateFrame.this, "Data updated Successfully!");
						id.setText("");
						gender.setText("");
					}
					con.close();
					ps.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnUpdateGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdateGender.setBackground(SystemColor.activeCaption);
		btnUpdateGender.setBounds(346, 150, 117, 23);
		contentPane.add(btnUpdateGender);

		JButton btnUpdateSalary = new JButton("Update Salary");
		btnUpdateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement ps = null;
				String sql = "Update employee set salary = ? where id = ?";

				String url = "jdbc:mysql://localhost:3306/employee";
				String dpath = "com.mysql.cj.jdbc.Driver";
				String user = "root";
				String password = "Aditya@123";
				try {
					Class.forName(dpath);
					con = DriverManager.getConnection(url, user, password);
					ps = con.prepareStatement(sql);
					int inid = Integer.parseInt(id.getText());
					int insalary = Integer.parseInt(salary.getText());

					ps.setInt(2, inid);
					ps.setInt(1, insalary);

					int nor = ps.executeUpdate();
					if (nor > 0) {
						JOptionPane.showMessageDialog(UpdateFrame.this, "Data updated Successfully!");
						id.setText("");
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
		btnUpdateSalary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdateSalary.setBackground(SystemColor.activeCaption);
		btnUpdateSalary.setBounds(346, 196, 117, 23);
		contentPane.add(btnUpdateSalary);

	}

}
