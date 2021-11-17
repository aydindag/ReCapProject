package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import ReCapProject.dataAccess.abstracts.ColorRepository;
import ReCapProject.entities.concretes.Color;

public class ColorDao implements ColorRepository {

	List<Color> colors;
	
	public ColorDao() {
		super();
		colors = new ArrayList<Color>();
	}

	@Override
	public void insert(Color color) {
		colors.add(color);
	}

	@Override
	public void delete(int colorId) {
		colors.remove(this.getById(colorId));
		
	}

	@Override
	public void update(int index, Color color) {
		colors.set(index, color);
	}

	@Override
	public Color getById(int id) {
		for(Color item : colors) {
			if(item.getColorId() == id)
				return item;
		}
		return null;
	}

	@Override
	public List<Color> getAll() {
		
		return colors;
	}
	
	@Override
	public int getIndex(Color color) {
		int index=0;
		for(Color item : this.colors ) {
			if(item.getColorId() == color.getColorId()){
				return index;
			}
			index++;
		}
		return -1;
	}

	
}
