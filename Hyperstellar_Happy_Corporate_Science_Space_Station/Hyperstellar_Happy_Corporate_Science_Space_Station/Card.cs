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

        public Card(Point point, Color color, int position)
        {
            CARDCOLOR = color;
            cardPosition = point;
            CARDID = position;
        }

        public Point GetCardPosition() { return cardPosition; }

        public void SetCardPosition(Point position) { cardPosition = position; }

        public Color GetCardColor() { return CARDCOLOR; }

        public int GetCardID() { return CARDID; }



    }
}
