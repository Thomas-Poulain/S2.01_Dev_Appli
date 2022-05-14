using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hyperstellar_Happy_Corporate_Science_Space_Station
{
    public class Pawn
    {
        private Point pawnPosition;
        private Color PAWNCOLOR;
        private int PAWNID;
        private Boolean isDelete;
        Pawn(Point point, Color color, int id)
        {
            pawnPosition = point;
            PAWNCOLOR = color;
            PAWNID = id;
            isDelete = false;
        }


        public Point GetPawnPosition() { return pawnPosition; }

        public void SetPawnPosition(Point point) { pawnPosition = point; }

        public Color GetPAWNCOLOR() { return PAWNCOLOR; }
        public int GetPAWNID() { return PAWNID; }
        public Boolean IsDelete() { return isDelete; }
        public void SetPawnState(Boolean state) { isDelete = state; }

    }
}
