package Commands;

import Input.Flat;
import Utils.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Команда группировки эллементов коллекции по значению поля площади
 */
public class CommandGroupCountingByArea extends CommandWithNotEmptyCollection {
	public CommandGroupCountingByArea(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		Map<Integer, List<Flat>> areaToFlatListMap = getAreaToFlatListMap();
		printGroupCountingByArea(areaToFlatListMap);
	}
	
	/**
	 * Проходится по всем элементам коллекции, добавляет квартиру в словарь по значению площади
	 *
	 * @return Словарь. Ключ: площадь. Значение: квартира
	 */
	private Map<Integer, List<Flat>> getAreaToFlatListMap() {
		Map<Integer, List<Flat>> areaToFlatListMap = new HashMap<>();
		for (Flat flat : context.collectionManager.getCollection()) {
			Integer areaCurrent = flat.getArea();
			
			if (! areaToFlatListMap.containsKey(areaCurrent))
				areaToFlatListMap.put(areaCurrent, new ArrayList<>());
			
			List<Flat> areaToFlatList = areaToFlatListMap.get(areaCurrent);
			areaToFlatList.add(flat);
			areaToFlatListMap.put(areaCurrent, areaToFlatList);
		}
		return areaToFlatListMap;
	}
	
	/**
	 * Выводит сгруппированные элементы коллекции по значению площади
	 * Само значение площади, и количество элементов в группе
	 *
	 * @param areaToFlatListMap Словарь. Ключ: площадь. Значение: квартира
	 */
	private void printGroupCountingByArea(Map<Integer, List<Flat>> areaToFlatListMap) {
		for (Map.Entry<Integer, List<Flat>> areaToFlatList : areaToFlatListMap.entrySet()) {
			System.out.println("Группа area=" + areaToFlatList.getKey() + "; Количество=" + areaToFlatList.getValue().size());
			for (Flat flat : areaToFlatList.getValue())
				System.out.println(flat.toString());
			System.out.println();
		}
	}
	
	@Override
	public String getName() {
		return "group_counting_by_area";
	}
	
	@Override
	public String getDescription() {
		return "сгруппировать элементы коллекции по значению поле area, вывести количество элементов в каждой группе";
	}
}
