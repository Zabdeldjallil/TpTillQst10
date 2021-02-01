package package1;

import java.awt.Graphics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;


public class Dessin extends JPanel{
	/**
     * stocke la liste des trains ayant �t� ajout�es �� cette zone de dessin.
     */
    private final List<TrainCercle> listeTrain = new CopyOnWriteArrayList();
    private final List<Visage> listeVisage = new CopyOnWriteArrayList();
    /**
     * retourne la largeur de la zone de dessin.
     *
     * @return la largeur.
     */
    public int getLargeur() {
        return getWidth();
    }

    /**
     * retourne la hauteur de la zone de dessin.
     *
     * @return la hauteur.
     */
    public int getHauteur() {
        return getHeight();
    }

    /**
     * ajoute un train cercle �� la zone de dessin.
     *
     * @param ch le train  �� ajouter au Dessin
     * @see train
     */
    public void ajouterObjet(TrainCercle t) {

        if (!listeTrain.contains(t)) {
            // l'objet n'est pas d��j�� dans la liste
            // on le rajoute a la liste des objets du dessin
        	listeTrain.add(t);
            // le dessin se r��affiche
            repaint();
            this.pause(10);
        }
    }
    public void ajouterObjet2(Visage v) {

        if (!listeVisage.contains(v)) {
            // l'objet n'est pas d��j�� dans la liste
            // on le rajoute a la liste des objets du dessin
        	listeVisage.add(v);
            // le dessin se r��affiche
            repaint();
            this.pause(10);
        }
    }
    /**
     * temporisation de l'animation.
     *
     * @param duree delai de temporisation en ms.
     */
    public void pause(int duree) {
        try {
            Thread.sleep(duree);
        } catch (InterruptedException e) {
        }
    }

    /**
     * affiche la zone de dessin et son contenu
     *
     * @param g le contexte graphique
     */
  
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //  dessiner les trains que contient le dessin
        for (TrainCercle c : listeTrain) {
            c.dessiner(g);
        }
        for (Visage c : listeVisage) {
            c.dessiner(g);
        }
    }
    /*public void paintComponent2(Graphics g) {
        super.paintComponent(g);
        //  dessiner les trains que contient le dessin
        for (Visage c : listeVisage) {
            c.dessiner(g);
        }
    }*/
    /**
     * fait deplacer d'un d��placement ��l��mentaire chacun des train cercles
     * que la zone de dessin contient.
     */
    public void animer() {
        //  dessiner les Objets que contient le dessin
        for (TrainCercle c : listeTrain) {
        	c.deplacer();
            
        }
        for (Visage v : listeVisage) {
        	v.deplacer();
            
        }
    }

}
