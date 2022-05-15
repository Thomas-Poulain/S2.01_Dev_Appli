using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hyperstellar_Happy_Corporate_Science_Space_Station
{
    internal class GameController
    {
        private GameLogic gamelogic;
        private MainWindow mainWindow;

        internal GameController(int numberOfPlayer)
        {

            gamelogic = new GameLogic(numberOfPlayer, this);
        }

        public GameLogic GetGameLogic() { return gamelogic; }
    }
}
