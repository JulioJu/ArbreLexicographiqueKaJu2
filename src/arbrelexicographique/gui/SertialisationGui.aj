package arbrelexicographique.gui;


aspect SertialisationGui {


    pointcut callMntmSaveActionPerformed() :
        target(GraphicInterface) &&
        call(void mntmSaveActionPerformed());

    void around () : callMntmSaveActionPerformed() {
      // this.tree.save("blop");
    }
}

// vim:ft=java
