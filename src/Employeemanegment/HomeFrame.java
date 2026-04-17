package Employeemanegment;

import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
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
	public HomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("EMPLOYEE MANEGMENT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(102, 11, 230, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(SystemColor.activeCaptionText);
		btnNewButton.setBounds(30, 65, 161, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Update Employee ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(30, 120, 161, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete Employee");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(30, 182, 161, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Fetches Employee");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FetchFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2_1.setBackground(SystemColor.activeCaption);
		btnNewButton_2_1.setBounds(257, 65, 161, 23);
		contentPane.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("Fetche All Employee");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2_2.setBounds(257, 120, 161, 23);
		contentPane.add(btnNewButton_2_2);

		JButton btnNewButton_2_3 = new JButton("EXIT ");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2_3.setBackground(SystemColor.activeCaption);
		btnNewButton_2_3.setBounds(257, 182, 161, 23);
		contentPane.add(btnNewButton_2_3);

	}
}
