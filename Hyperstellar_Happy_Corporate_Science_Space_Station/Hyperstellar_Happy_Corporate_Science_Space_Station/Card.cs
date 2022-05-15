using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hyperstellar_Happy_Corporate_Science_Space_Station
{
    public class Card
    {
        private Color CARDCOLOR;
        private Point cardPosition;
        private int CARDID;
        private Size size;

        public Card(Point point, Color color, int id)
        {
            CARDCOLOR = color;
            cardPosition = point;
            CARDID = id;
            size = new Size(20, 40);
        }

        public Point GetCardPosition() { return cardPosition; }

        public void SetCardPosition(Point position) { cardPosition = position; }

        public Color GetCardColor() { return CARDCOLOR; }

        public int GetCardID() { return CARDID; }

        public void DrawCard(Graphics e) 
        {
            Pen p = new Pen(CARDCOLOR, 3);
            Rectangle r = new Rectangle(cardPosition, size);
            e.DrawRectangle(p, r);
        }

    }
}
