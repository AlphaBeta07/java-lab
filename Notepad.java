import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame {
    private final JTextArea area = new JTextArea();
    private final JFileChooser chooser = new JFileChooser();

    public Notepad() {
        setTitle("MyNotepad");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JScrollPane(area), BorderLayout.CENTER);

        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newIt = new JMenuItem("New");
        JMenuItem openIt = new JMenuItem("Open");
        JMenuItem saveIt = new JMenuItem("Save");
        JMenuItem exitIt = new JMenuItem("Exit");

        newIt.addActionListener(e -> area.setText(""));
        openIt.addActionListener(e -> openFile());
        saveIt.addActionListener(e -> saveFile());
        exitIt.addActionListener(e -> System.exit(0));

        file.add(newIt); file.add(openIt); file.add(saveIt); file.addSeparator(); file.add(exitIt);
        mb.add(file);
        setJMenuBar(mb);
        setLocationRelativeTo(null);
    }

    private void openFile() {
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                area.setText("");
                String line;
                while ((line = br.readLine()) != null) area.append(line + "\n");
            } catch (IOException ex) { JOptionPane.showMessageDialog(this, "Read error: " + ex.getMessage()); }
        }
    }

    private void saveFile() {
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
                bw.write(area.getText());
            } catch (IOException ex) { JOptionPane.showMessageDialog(this, "Save error: " + ex.getMessage()); }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Notepad().setVisible(true));
    }
}
