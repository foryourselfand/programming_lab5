package Commands;

import Input.Flat;
import Input.House;
import Utils.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Команда вывода уникальных значений поля дом
 */
public class CommandPrintUniqueHouse extends CommandWithNotEmptyCollection {
	public CommandPrintUniqueHouse(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		Map<House, Integer> houseToCountMap = getHouseToCountMap();
		List<House> uniqueHouses = getUniqueHouses(houseToCountMap);
		printUniqueHouses(uniqueHouses);
	}
	
	/**
	 * Возвращает Словарь. Ключ: дом. Значение: Количество конкретного значения дома в коллекции
	 *
	 * @return Словарь. Ключ: дом. Значение: Количество конкретного значения дома в коллекции
	 */
	private Map<House, Integer> getHouseToCountMap() {
		Map<House, Integer> houseToCountMap = new HashMap<>();
		
		for (Flat flat : this.context.collectionManager.getCollection()) {
			House houseCurrent = flat.getHouse();
			
			if (! houseToCountMap.containsKey(houseCurrent))
				houseToCountMap.put(houseCurrent, 1);
			else {
				Integer houseToCountPrevious = houseToCountMap.get(houseCurrent);
				Integer houseToCountIncremented = houseToCountPrevious + 1;
				houseToCountMap.put(houseCurrent, houseToCountIncremented);
			}
		}
		return houseToCountMap;
	}
	
	/**
	 * Возвращает лист уникальных домов
	 *
	 * @param houseToCountMap Словарь. Ключ: дом. Значение: Количество конкретного значения дома в коллекции
	 * @return лист уникальных домов
	 */
	private List<House> getUniqueHouses(Map<House, Integer> houseToCountMap) {
		List<House> uniqueHouses = new ArrayList<>();
		for (Map.Entry<House, Integer> houseToCount : houseToCountMap.entrySet()) {
			if (houseToCount.getValue() == 1)
				uniqueHouses.add(houseToCount.getKey());
		}
		return uniqueHouses;
	}
	
	/**
	 * Выводит уникальные значения дома
	 *
	 * @param uniqueHouses
	 */
	private void printUniqueHouses(List<House> uniqueHouses) {
		if (uniqueHouses.isEmpty())
			System.out.println("Уникальных значений поля house - нет");
		else {
			System.out.println("Уникальные значения поля house: ");
			for (House house : uniqueHouses)
				System.out.println(house.toString());
		}
	}
	
	
	@Override
	public String getName() {
		return "print_unique_house";
	}
	
	@Override
	public String getDescription() {
		return "вывести уникальные значения поля house";
	}
}
