package View.Graphical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.GameController;
import Model.CardColor;
import View.View;

@SuppressWarnings("serial")
public class ViewColorLastCard extends JPanel implements View {

    private ViewCard color;
    private GameController gc;

    public ViewColorLastCard(GameController gc) {
        this.setLayout(new GridLayout(0, 2));
        this.gc = gc;
        JLabel currentColor = new JLabel("The current color is :");
        currentColor.setForeground(Color.YELLOW);
        this.add(currentColor);
        JPanel cardContainer = new JPanel(new BorderLayout());
        color = new ViewCard();
        color.setOpaque(false);
        cardContainer.setOpaque(false);        
        cardContainer.add(color, BorderLayout.CENTER);
        this.add(cardContainer);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

        this.color.setImage(ViewColorLastCard.getPathOf(this.gc.getDiscard().getLastCardColor()));
        color.setSize(100, 150);
        this.color.revalidate();
        this.color.repaint();
    }

    private static String getPathOf(CardColor c) {
        String out = "";
        switch (c) {
            case Spades:
                out += "spades";
                break;
            case Hearts:
                out += "hearts";
                break;
            case Diamonds:
                out += "diamonds";
                break;
            case Clubs:
                out += "clubs";
                break;
            case Joker:
                out += "joker";
                break;
        }
        return out;

    }
}
