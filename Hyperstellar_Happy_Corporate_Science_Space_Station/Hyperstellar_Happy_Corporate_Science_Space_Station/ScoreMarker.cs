using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hyperstellar_Happy_Corporate_Science_Space_Station
{
   public class ScoreMarker
    {
        private Point markerPosition;

        private Color markerColor;

        private int MARKERID;

        private Boolean isDelete;
        ScoreMarker(Point point, Color color, int id)
        {
            markerColor = color;
            markerPosition = point;
            MARKERID = id;
        }

        public Point GetMarkerPosition() { return markerPosition}

        public void SetMarkerPosition(Point point) { markerPosition = point; }
        public Color GetMarkerColor() { return markerColor; }
        public void SetMarkerColor(Color color){ markerColor = color; }
        public int GetMAKERID() { return MARKERID; }

        public Boolean GetState() { return isDelete; }
        public void SetState(Boolean state) { isDelete = state; }

        private void drawnMarker() { }
    }
}
