using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace Hyperstellar_Happy_Corporate_Science_Space_Station
{
    internal class GameLogic
    {
        private GameRubber currentRubber;
        private GameController gameController;
        private List<Player> playerList = new List<Player>();
        public List<Card> deck = new List<Card>();
        private List<Card> discarded = new List<Card>();
        int numberOfPlayers;

        internal GameLogic(int numberOfPlayers, GameController gameController)
        {
            this.gameController = gameController;
            this.numberOfPlayers = numberOfPlayers;

            intializePlayers();
            initializeCards();
        }

        private void intializePlayers() 
        {
            for (int i = 0; i < this.numberOfPlayers; i++)
            {
                Player player = new Player(i);
                playerList.Add(player);
            }
        }

        private void initializeCards()
        {
            Point point = new Point(200,200);
            initializeYellow(point);
            point = new Point(240, 200);
            initializeBlue(point);
            point = new Point(280, 200);
            initializeRed(point);
            initializeGreen(point);
            initializePurple(point);
            initializeBlack(point);
            initializeWhite(point);
        }

        private void initializeYellow(Point point) 
        { 
            for(int i = 0; i < 20; i++)
            {
                Card card = new Card(point, Color.Yellow,i);
                deck.Add(card);
            }
        }
        private void initializeBlue(Point point)
        {
            for (int i = 20; i < 40; i++)
            {
                Card card = new Card(point, Color.Blue, i);
                deck.Add(card);
            }
        }
        private void initializeRed(Point point)
        {
            for (int i = 40; i < 60; i++)
            {
                Card card = new Card(point, Color.Red, i);
                deck.Add(card);
            }
        }
        private void initializeGreen(Point point)
        {
            for (int i = 60; i < 80; i++)
            {
                Card card = new Card(point, Color.Green, i);
                deck.Add(card);
            }
        }
        private void initializePurple(Point point)
        {
            for (int i = 80; i < 90; i++)
            {
                Card card = new Card(point, Color.Purple, i);
                deck.Add(card);
            }
        }
        private void initializeBlack(Point point)
        {
            for (int i = 90; i < 98; i++)
            {
                Card card = new Card(point, Color.Black, i);
                deck.Add(card);
            }
        }
        private void initializeWhite(Point point)
        {
            for (int i = 0; i < 20; i++)
            {
                Card card = new Card(point, Color.White, i);
                deck.Add(card);
            }
        }


    }
}
