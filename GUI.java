package notepadfinal;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
public class GUI implements ActionListener{
	
	JFrame window;
	
	//textArea
	JTextArea textArea;
	JScrollPane scrollpane;
	boolean wordWrapOn = false;
	
	//TOP MenuBar
	JMenuBar menuBar;
	JMenu menuFile,menuEdit, menuFormat,menuColor;
	
	//FileMenu
	JMenuItem INew,IOpen,ISave,ISaveAs,IExit;
	
	//EditMenu
	JMenuItem IUndo, IRedo;
	
	
	
	//FormatMenu
	JMenuItem IWrap ,IFontArial,IFontCSMS,IFontTNR,IFontSize8,IFontSize12,IFontSize16,IFontSize20,IFontSize24,IFontSize28;
	JMenu menuFont,menuFontSize;
	
	//colorMenu
	JMenuItem iColor1,iColor2, iColor3 ,iColor4,iColor5;
	
	Function_File file=new Function_File(this);
	Function_Format format=new Function_Format(this);
	Function_Color color=new Function_Color(this);
	Function_Edit edit = new Function_Edit(this);
	
	KeyHandler KHandler = new KeyHandler(this);
	
	UndoManager um = new UndoManager();
	
	
	
	
	public static void main(String[] args) {
		 new GUI();
	}
	
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFilemenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();
		
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");
		
		window.setVisible(true);
	}
	
	public void createWindow() {
		
		window= new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea(){
		
		textArea = new JTextArea();
		
		textArea.addKeyListener(KHandler);
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		scrollpane =new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollpane);
		
	}
	public void createMenuBar() {
		
		menuBar= new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile=new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit=new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat=new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor=new JMenu("Color");
		menuBar.add(menuColor);
	}
	public void createEditMenu() {
		
		IUndo = new JMenuItem("Undo");
		IUndo.addActionListener(this);
		IUndo.setActionCommand("Undo");
		menuEdit.add(IUndo);
		
		
		IRedo = new JMenuItem("Redo");
		IRedo.addActionListener(this);
		IRedo.setActionCommand("Redo");
		menuEdit.add(IRedo);
		
		
	}
	public void createFilemenu() {
		
		INew=new JMenuItem("new");
		INew.addActionListener(this);
		INew.setActionCommand("New");
		menuFile.add(INew);
		
		IOpen=new JMenuItem("open");
		IOpen.addActionListener(this);
		IOpen.setActionCommand("Open");
		menuFile.add(IOpen);
		
		ISave=new JMenuItem("save");
		ISave.addActionListener(this);
		ISave.setActionCommand("Save");
		menuFile.add(ISave);
		
		ISaveAs=new JMenuItem("SaveAs");
		ISaveAs.addActionListener(this);
		ISaveAs.setActionCommand("SaveAs");
		menuFile.add(ISaveAs);
		
		IExit=new JMenuItem("Exit");
		IExit.addActionListener(this);
		IExit.setActionCommand("Exit");
		menuFile.add(IExit);
		
		
		
	}
	public void createFormatMenu() {
		
		IWrap = new JMenuItem("Word Wrap: Off");
		IWrap.addActionListener(this);
		IWrap.setActionCommand("Word Wrap");
		menuFormat.add(IWrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		IFontArial = new JMenuItem("Arial");
		IFontArial.addActionListener(this);
		IFontArial.setActionCommand("Arial");
		menuFont.add(IFontArial);
		
		IFontCSMS = new JMenuItem("Comic Sans MS");
		IFontCSMS.addActionListener(this);
		IFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(IFontCSMS);
		
		IFontTNR = new JMenuItem("Times New Roman");
		IFontTNR.addActionListener(this);
		IFontTNR.setActionCommand("Times New Roman");
		menuFont.add(IFontTNR);
		
		menuFontSize=new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		IFontSize8= new JMenuItem("8");
		IFontSize8.addActionListener(this);
		IFontSize8.setActionCommand("size8");
		menuFontSize.add(IFontSize8);
		
		IFontSize12= new JMenuItem("12");
		IFontSize12.addActionListener(this);
		IFontSize12.setActionCommand("size12");
		menuFontSize.add(IFontSize12);
		
		IFontSize16= new JMenuItem("16");
		IFontSize16.addActionListener(this);
		IFontSize16.setActionCommand("size16");
		menuFontSize.add(IFontSize16);
		
		IFontSize20= new JMenuItem("20");
		IFontSize20.addActionListener(this);
		IFontSize20.setActionCommand("size20");
		menuFontSize.add(IFontSize20);
		
		IFontSize24= new JMenuItem("24");
		IFontSize24.addActionListener(this);
		IFontSize24.setActionCommand("size24");
		menuFontSize.add(IFontSize24);
		
		IFontSize28= new JMenuItem("28");
		IFontSize28.addActionListener(this);
		IFontSize28.setActionCommand("size28");
		menuFontSize.add(IFontSize28);
		
	}
	
   public void createColorMenu() {
	   
	   iColor1= new JMenuItem("White");
	   iColor1.addActionListener(this);
	   iColor1.setActionCommand("White");
	   menuColor.add(iColor1);
	   
	   iColor2= new JMenuItem("Black");
	   iColor2.addActionListener(this);
	   iColor2.setActionCommand("Black");
	   menuColor.add(iColor2);
	   
	   iColor3= new JMenuItem("Blue");
	   iColor3.addActionListener(this);
	   iColor3.setActionCommand("Blue");
	   menuColor.add(iColor3);
	   

	   iColor4= new JMenuItem("Yellow");
	   iColor4.addActionListener(this);
	   iColor4.setActionCommand("Yellow");
	   menuColor.add(iColor4);
	   
	   iColor5= new JMenuItem("Blue1");
	   iColor5.addActionListener(this);
	   iColor5.setActionCommand("Blue1");
	   menuColor.add(iColor5);
	   
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		switch(command) {
		case "New": file.newFile();
		break;
		case "Open": file.open();
		break;
		case "Save": file.save();
		break;
		case "SaveAs": file.saveAs();
		break;
		case "Exit": file.exit();
		break;
		case "Undo" :edit.undo();
		break;
		case "Redo" :edit.redo();
		break;
		case "Word Wrap": format.wordWrap();
		break;
		case "Arial": format.setFont(command);
		break;
		case "Comic Sans MS": format.setFont(command);
		break;
		case "Times New Roman": format.setFont(command);
		break;
		case "size8": format.createFont(8);
		break;
		case "size12": format.createFont(12);
		break;
		case "size16": format.createFont(16);
		break;
		case "size20": format.createFont(20);
		break;
		case "size24": format.createFont(24);
		break;
		case "size28": format.createFont(28);
		break;
		case "White": color.changeColor(command);
		break;
		case "Black": color.changeColor(command);
		break;
		case "Blue": color.changeColor(command);
		break;
		case "Yellow": color.changeColor(command);
		break;
		case "Blue1": color.changeColor(command);
		break;
		}
		
	}
     
}


