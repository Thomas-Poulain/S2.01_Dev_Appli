using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Hyperstellar_Happy_Corporate_Science_Space_Station
{
    internal static class Program
    {
        /// <summary>
        /// Point d'entrée principal de l'application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            int numbOfPlayers = 1;
            GameController gameController = new GameController(numbOfPlayers);  // New GameController, GameLogic
            Application.Run(new MainWindow(gameController));
        }
    }
}
