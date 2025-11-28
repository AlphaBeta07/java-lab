import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyMouseDemo extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private final JTextArea area = new JTextArea(10, 30);

    public KeyMouseDemo() {
        setTitle("Key & Mouse Events Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane sp = new JScrollPane(area);
        add(sp);
        addKeyListener(this);               // frame listens for keys
        area.addKeyListener(this);          // text area also listens
        area.addMouseListener(this);
        area.addMouseMotionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        // request focus for key events
        area.setFocusable(true);
        area.requestFocusInWindow();
    }

    private void log(String s) { area.append(s + "\n"); area.setCaretPosition(area.getDocument().getLength()); }

    // KeyListener
    public void keyPressed(KeyEvent e) { log("KeyPressed: " + KeyEvent.getKeyText(e.getKeyCode())); }
    public void keyReleased(KeyEvent e) { log("KeyReleased: " + KeyEvent.getKeyText(e.getKeyCode())); }
    public void keyTyped(KeyEvent e) { log("KeyTyped: " + e.getKeyChar()); }

    // MouseListener
    public void mouseClicked(MouseEvent e) { log("MouseClicked at " + e.getX() + "," + e.getY() + " button=" + e.getButton() + " clicks=" + e.getClickCount()); }
    public void mouseEntered(MouseEvent e) { log("MouseEntered"); }
    public void mouseExited(MouseEvent e) { log("MouseExited"); }
    public void mousePressed(MouseEvent e) { log("MousePressed"); }
    public void mouseReleased(MouseEvent e) { log("MouseReleased"); }

    // MouseMotionListener
    public void mouseDragged(MouseEvent e) { log("MouseDragged at " + e.getX() + "," + e.getY()); }
    public void mouseMoved(MouseEvent e) { /* avoid flooding log on move; optional */ }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KeyMouseDemo::new);
    }
}
