import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    private TextArea ta1 = new TextArea();
    private JPasswordField pf= new JPasswordField();
    private JLabel  lb1 =new JLabel();
    private JButton jb1 = new JButton("Change");
    private JButton jb2 = new JButton("Exit");
    private Container cp ;
    private ScrollPane spw = new ScrollPane();
    private ScrollPane spe = new ScrollPane();
    private JPanel jpc =new JPanel(new GridLayout(3,1,1,1));


    Frame(){
        init();
    }
    public void init(){
        this.setBounds(100,100,500,500);
        cp = this.getContentPane();
        cp.add(jpc, BorderLayout.CENTER);
        cp.add(spw, BorderLayout.WEST);
        cp.add(spe, BorderLayout.EAST);

        spw.add(ta1);
        spe.add(lb1);
        jpc.add(pf);
        jpc.add(jb1);
        jpc.add(jb2);











        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldstr = ta1.getText();
                String key = new String(pf.getPassword());
                String newstr = "";
                char []c = oldstr.toCharArray();
                char []p = key.toCharArray();
                for (int i = 0; i < oldstr.length(); i++){
                    int j = i % key.length();

                    int r = (int) c[j]^(int) p[j];
                    newstr = newstr + r;
                    lb1.setText(newstr);
                }
            }
        });
    }


}
