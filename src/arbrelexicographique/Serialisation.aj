package arbrelexicographique;

import java.io.Serializable;

public aspect Serialisation {
	declare parents : arbrelexicographique.ArbreLexicographique implements Serializable;
}