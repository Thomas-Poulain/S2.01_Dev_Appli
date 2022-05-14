using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hyperstellar_Happy_Corporate_Science_Space_Station
{
    public class Player
    {
        int playerId;
        int water;
        int energy;
        int score;
        List<Card> hand = new List<Card>();


        public Player(int id)
        {
            playerId = id;
        }

        public int getId() { return playerId; }

        public void MouvementCounter() { }

        private void drawMouvementCounter() { }
    }
}
