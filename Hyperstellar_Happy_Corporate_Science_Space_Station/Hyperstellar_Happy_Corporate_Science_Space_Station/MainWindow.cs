using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Hyperstellar_Happy_Corporate_Science_Space_Station
{
    public partial class MainWindow : Form
    {
        private GameController gameController;
        
        private List<List<Card>> allCardsView = new List<List<Card>>();
        internal MainWindow(GameController gameController)
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.None;
            WindowState = FormWindowState.Maximized;
            this.gameController = gameController;
        }

        private void MainWindow_Paint(object sender, PaintEventArgs e)
        {
           
        }

        private void drawCurrentMain(int numberOfPlayers)
        {
            for (int i = 0; i < numberOfPlayers; i++)
            {

            }
        }
    }
}
