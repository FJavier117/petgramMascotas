package f_mendez07.blogspot.com.petagram;

import java.util.Comparator;

import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

public class ComparaLikesMascotas implements Comparator<Mascotas> {

	@Override
	public int compare(Mascotas m1, Mascotas m2) {
		if(m1.getLikes() > m2.getLikes()) {
			return -1;
		}else if(m1.getLikes()>m2.getLikes()){
			return 0;
		}else {
			return 1;
		}
	}

}
