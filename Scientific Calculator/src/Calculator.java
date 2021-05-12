import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Calculator {
	
	double first;
	double second;
	double result;
	String operation;
	String answer;

	private JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SCIENTIFIC CALCULATOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 370, 33);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEnabled(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setBounds(10, 53, 370, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPlusMinus = new JButton("+/-");
		btnPlusMinus.setEnabled(false);
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(String.valueOf(textField.getText()));
				a=a*(-1);
				textField.setText(String.valueOf(a));
			}
		});
		btnPlusMinus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPlusMinus.setBounds(10, 484, 66, 47);
		frame.getContentPane().add(btnPlusMinus);
		
		JButton btnLog = new JButton("Log");
		btnLog.setEnabled(false);
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.log(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnLog.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLog.setBounds(86, 199, 66, 47);
		frame.getContentPane().add(btnLog);
		
		JButton btn1 = new JButton("1");
		btn1.setEnabled(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn1.getText();
				textField.setText(number);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn1.setBounds(86, 427, 66, 47);
		frame.getContentPane().add(btn1);
		
		JButton btn0 = new JButton("0");
		btn0.setEnabled(false);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn0.getText();
				textField.setText(number);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn0.setBounds(86, 484, 142, 47);
		frame.getContentPane().add(btn0);
		
		JButton btnSin = new JButton("sin");
		btnSin.setEnabled(false);
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.sin(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnSin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSin.setBounds(162, 142, 66, 47);
		frame.getContentPane().add(btnSin);
		
		JButton btnBackspace = new JButton("\uF0E7");
		btnBackspace.setEnabled(false);
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backSpace = null;
				if(textField.getText().length()>0) {
					StringBuilder str = new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backSpace=str.toString();
					textField.setText(backSpace);
				}
			}
		});
		btnBackspace.setFont(new Font("Dialog", Font.BOLD, 22));
		btnBackspace.setBounds(238, 256, 66, 47);
		frame.getContentPane().add(btnBackspace);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setEnabled(false);
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second = Double.parseDouble(textField.getText());
				if(operation=="+") {
					result=first+second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="-") {
					result=first-second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="*") {
					result=first*second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="/") {
					result=first/second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="%") {
					result=(first/second)*100;
					answer=String.format("%.2f", result);
					textField.setText(answer+"%");
				}
				else if(operation=="X^Y") {
					double resultt = 0;
					for(int i=0;i<second;i++) {
						resultt=first*second;
					}
					answer=String.format("%.2f", resultt);
					textField.setText(answer);
				}
			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnEqual.setBounds(314, 484, 66, 47);
		frame.getContentPane().add(btnEqual);
		
		JButton btn2 = new JButton("2");
		btn2.setEnabled(false);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn2.getText();
				textField.setText(number);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn2.setBounds(162, 427, 66, 47);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setEnabled(false);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn3.getText();
				textField.setText(number);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn3.setBounds(238, 427, 66, 47);
		frame.getContentPane().add(btn3);
		
		JButton btn6 = new JButton("6");
		btn6.setEnabled(false);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn6.getText();
				textField.setText(number);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn6.setBounds(238, 370, 66, 47);
		frame.getContentPane().add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.setEnabled(false);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn5.getText();
				textField.setText(number);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn5.setBounds(162, 370, 66, 47);
		frame.getContentPane().add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.setEnabled(false);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn4.getText();
				textField.setText(number);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn4.setBounds(86, 370, 66, 47);
		frame.getContentPane().add(btn4);
		
		JButton btn7 = new JButton("7");
		btn7.setEnabled(false);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn7.getText();
				textField.setText(number);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn7.setBounds(86, 313, 66, 47);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setEnabled(false);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn8.getText();
				textField.setText(number);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn8.setBounds(162, 313, 66, 47);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setEnabled(false);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn9.getText();
				textField.setText(number);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn9.setBounds(238, 313, 66, 47);
		frame.getContentPane().add(btn9);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setEnabled(false);
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText(null);
				operation="/";
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnDiv.setBounds(314, 427, 66, 47);
		frame.getContentPane().add(btnDiv);
		
		JButton btnMul = new JButton("*");
		btnMul.setEnabled(false);
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText(null);
				operation="*";
			}
		});
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnMul.setBounds(314, 370, 66, 47);
		frame.getContentPane().add(btnMul);
		
		JButton btnSub = new JButton("-");
		btnSub.setEnabled(false);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText(null);
				operation="-";
			}
		});
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSub.setBounds(314, 313, 66, 47);
		frame.getContentPane().add(btnSub);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText(null);
				operation="+";
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAdd.setBounds(314, 256, 66, 47);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDot = new JButton(".");
		btnDot.setEnabled(false);
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnDot.setBounds(238, 484, 66, 47);
		frame.getContentPane().add(btnDot);
		
		JButton btnClear = new JButton("C");
		btnClear.setEnabled(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnClear.setBounds(162, 256, 66, 47);
		frame.getContentPane().add(btnClear);
		
		JButton btnPercent = new JButton("%");
		btnPercent.setEnabled(false);
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText(null);
				operation="%";
			}
		});
		btnPercent.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnPercent.setBounds(86, 256, 66, 47);
		frame.getContentPane().add(btnPercent);
		
		JButton btnXy = new JButton("X^Y");
		btnXy.setEnabled(false);
		btnXy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText(null);
				operation="X^Y";
			}
		});
		btnXy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXy.setBounds(10, 256, 66, 47);
		frame.getContentPane().add(btnXy);
		
		JButton btnNewButton_6_1 = new JButton("n!");
		btnNewButton_6_1.setEnabled(false);
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(textField.getText());
				double fact = 1;
				while(a!=0) {
					fact*=a;
					a--;
				}
				textField.setText("");
				textField.setText(textField.getText()+fact);
			}
		});
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_6_1.setBounds(10, 427, 66, 47);
		frame.getContentPane().add(btnNewButton_6_1);
		
		JButton btnNewButton_6_2 = new JButton("X^2");
		btnNewButton_6_2.setEnabled(false);
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = (Double.parseDouble(textField.getText()));
				a=a*a;
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnNewButton_6_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_6_2.setBounds(10, 370, 66, 47);
		frame.getContentPane().add(btnNewButton_6_2);
		
		JButton btnNewButton_6_3 = new JButton("X^3");
		btnNewButton_6_3.setEnabled(false);
		btnNewButton_6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = (Double.parseDouble(textField.getText()));
				a=a*a*a;
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnNewButton_6_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_6_3.setBounds(10, 313, 66, 47);
		frame.getContentPane().add(btnNewButton_6_3);
		
		JButton btnCos = new JButton("cos");
		btnCos.setEnabled(false);
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.cos(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnCos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCos.setBounds(238, 142, 66, 47);
		frame.getContentPane().add(btnCos);
		
		JButton btnTan = new JButton("tan");
		btnTan.setEnabled(false);
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.tan(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnTan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTan.setBounds(314, 142, 66, 47);
		frame.getContentPane().add(btnTan);
		
		JButton btnSinh = new JButton("sinh");
		btnSinh.setEnabled(false);
		btnSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.sinh(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnSinh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSinh.setBounds(162, 199, 66, 47);
		frame.getContentPane().add(btnSinh);
		
		JButton btnCosh = new JButton("cosh");
		btnCosh.setEnabled(false);
		btnCosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.cosh(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnCosh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCosh.setBounds(238, 199, 66, 47);
		frame.getContentPane().add(btnCosh);
		
		JButton btnTanh = new JButton("tanh");
		btnTanh.setEnabled(false);
		btnTanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.tanh(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnTanh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTanh.setBounds(314, 199, 66, 47);
		frame.getContentPane().add(btnTanh);
		
		JButton btnNewButton_8_1 = new JButton("1/x");
		btnNewButton_8_1.setEnabled(false);
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = 1/(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnNewButton_8_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_8_1.setBounds(10, 199, 66, 47);
		frame.getContentPane().add(btnNewButton_8_1);
		
		JButton btnNewButton_8_2 = new JButton("\u221A");
		btnNewButton_8_2.setEnabled(false);
		btnNewButton_8_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.sqrt(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnNewButton_8_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_8_2.setBounds(10, 142, 66, 47);
		frame.getContentPane().add(btnNewButton_8_2);
		
		JButton btnNewButton_8_3 = new JButton("e^x");
		btnNewButton_8_3.setEnabled(false);
		btnNewButton_8_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.exp(Double.parseDouble(textField.getText()));
				textField.setText(null);
				textField.setText(textField.getText()+a);
			}
		});
		btnNewButton_8_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_8_3.setBounds(86, 142, 66, 47);
		frame.getContentPane().add(btnNewButton_8_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ON");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn0.setEnabled(true);
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
				btnAdd.setEnabled(true);
				btnBackspace.setEnabled(true);
				btnClear.setEnabled(true);
				btnCos.setEnabled(true);
				btnCosh.setEnabled(true);
				btnDiv.setEnabled(true);
				btnDot.setEnabled(true);
				btnEqual.setEnabled(true);
				btnLog.setEnabled(true);
				btnMul.setEnabled(true);
				btnNewButton_6_1.setEnabled(true);
				btnNewButton_6_2.setEnabled(true);
				btnNewButton_6_3.setEnabled(true);
				btnNewButton_8_1.setEnabled(true);
				btnNewButton_8_2.setEnabled(true);
				btnNewButton_8_3.setEnabled(true);
				btnPercent.setEnabled(true);
				btnPlusMinus.setEnabled(true);
				btnSin.setEnabled(true);
				btnSinh.setEnabled(true);
				btnSub.setEnabled(true);
				btnTan.setEnabled(true);
				btnTanh.setEnabled(true);
				btnXy.setEnabled(true);
				textField.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(6, 115, 54, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnOff = new JRadioButton("OFF");
		rdbtnOff.setSelected(true);
		rdbtnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				btn0.setEnabled(false);
				btn1.setEnabled(false);
				btn2.setEnabled(false);
				btn3.setEnabled(false);
				btn4.setEnabled(false);
				btn5.setEnabled(false);
				btn6.setEnabled(false);
				btn7.setEnabled(false);
				btn8.setEnabled(false);
				btn9.setEnabled(false);
				btnAdd.setEnabled(false);
				btnBackspace.setEnabled(false);
				btnClear.setEnabled(false);
				btnCos.setEnabled(false);
				btnCosh.setEnabled(false);
				btnDiv.setEnabled(false);
				btnDot.setEnabled(false);
				btnEqual.setEnabled(false);
				btnLog.setEnabled(false);
				btnMul.setEnabled(false);
				btnNewButton_6_1.setEnabled(false);
				btnNewButton_6_2.setEnabled(false);
				btnNewButton_6_3.setEnabled(false);
				btnNewButton_8_1.setEnabled(false);
				btnNewButton_8_2.setEnabled(false);
				btnNewButton_8_3.setEnabled(false);
				btnPercent.setEnabled(false);
				btnPlusMinus.setEnabled(false);
				btnSin.setEnabled(false);
				btnSinh.setEnabled(false);
				btnSub.setEnabled(false);
				btnTan.setEnabled(false);
				btnTanh.setEnabled(false);
				btnXy.setEnabled(false);
				textField.setEnabled(false);
			}
		});
		buttonGroup.add(rdbtnOff);
		rdbtnOff.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnOff.setBounds(62, 115, 54, 21);
		frame.getContentPane().add(rdbtnOff);
		frame.setBounds(100, 100, 412, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
