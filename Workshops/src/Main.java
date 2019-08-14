import javax.swing.*;
import java.awt.*;

class Main extends JFrame {
    
    class App extends JPanel {
         //Stage stage, get rid of grid as stage has one of those already
        Grid grid;
        Stage stage;

        public App() {
            setPreferredSize(new Dimension(720, 720));
            //grid = new Grid();
            stage = new Stage();
        }

        @Override
        public void paint(Graphics g) {
           //grid.paint(g, getMousePosition());
           stage.grid.paint(g, getMousePosition());
           stage.lion.paint(g);
           stage.rabbit.paint(g);
           stage.puppy.paint(g);

        }

    }

    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        App canvas = new App();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            this.repaint();
        }
    }
}