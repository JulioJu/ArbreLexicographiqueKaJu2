package arbrelexicographique;

public aspect SingletonSurNoeudVide {
	private NoeudVide instance = new NoeudVide();

	private pointcut appelConstructeur() : call(NoeudVide.new()) && ! within(SingletonSurNoeudVide);

	NoeudVide around() : appelConstructeur() {
		//System.out.println("On est en train d'appeler l'advice");
		return instance;
	}
}

// vim: ft=java
