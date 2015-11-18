import java.applet.*;
import java.awt.event.*;
import java.awt.*;
/*
<applet code="menu1" width=500 height=500>
</applet>
*/
class MenuFrame extends Frame implements ActionListener , ItemListener{
static String msg = "";
static CheckboxMenuItem debug, test;

MenuFrame (String title) {
super(title);
MenuBar mbar = new MenuBar();
setMenuBar (mbar);

Menu file = new Menu ("File");
MenuItem item1, item2, item3;
item1 = new MenuItem("New");
item2 = new MenuItem ("--");
item3 = new MenuItem("Close");
file.add(item1);
file.add(item2);
file.add(item3);
mbar.add(file);

Menu view = new Menu ("View");
debug = new CheckboxMenuItem ("debug");
test = new CheckboxMenuItem("test");
view.add(debug);
view.add(test);
mbar.add(view);

item1.addActionListener(this);
item2.addActionListener(this);
item3.addActionListener(this);
debug.addActionListener(this);
test.addActionListener(this);
MyWindowAdapter adapter = new MyWindowAdapter(this);
addWindowListener(adapter);

}
public void actionPerformed (ActionEvent ae) {
msg = "You selected: ";
String x = ae.getActionCommand();
msg += x;
repaint();
}

public void itemStateChanged (ItemEvent ie){
repaint();
}
}


class MyWindowAdapter extends WindowAdapter {
MenuFrame menuFrame;
public MyWindowAdapter (MenuFrame menuFrame1) {
this.menuFrame = menuFrame1;
}
public void windowClosing (WindowEvent we){
menuFrame.setVisible(false);
}
}

public class menu1 extends Applet {
Frame f;

public void init() {
f = new MenuFrame ("Menu1");
f.setSize(500,500);
f.setVisible(true);
}

public void start() {
f.setVisible(true);
}
public void stop() {
f.setVisible(false);
}
public void paint(Graphics g) {
g.drawString(MenuFrame.msg, 50, 50);
if (MenuFrame.debug.getState()) {
g.drawString("Debug is on", 50, 70);
}
else g.drawString("Debug is off", 50, 90);
if (MenuFrame.test.getState()) {
g.drawString("Test is on", 50, 110);
}
else g.drawString("Test is off", 50, 130);
}
}

