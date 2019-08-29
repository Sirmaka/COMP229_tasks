import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class Main extends JFrame {
    
    class App extends JPanel {
        
        Stage stage;

        public App() {
            setPreferredSize(new Dimension(880, 720));
            try{
                stage = StageReader.readStage("data/stage1.rvb");
                //stage = StageReader.readStage("data");
            }
            catch(IOException e){
                System.out.println("IO Exception encountered.");
                System.exit(0);
            }

            
        }

        @Override
        public void paint(Graphics g) {
            stage.paint(g, getMousePosition());
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
            try{
                Thread.sleep(20);
            }catch(InterruptedException e){
                System.out.printf("Thread was interupted: " + e.toString());
            }
                this.repaint();
        }
    }
}