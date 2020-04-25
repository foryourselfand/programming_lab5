package Utils;

import Input.Variable;

import java.util.*;

/**
 * Обертка для доступа к листу, сету и длинне коллекции
 */
public class Header {
	/**
	 * Лист коллекции
	 */
	private final List<String> list;
	
	/**
	 * Сет коллекции
	 */
	private Set<String> set;
	
	/**
	 * Количество элементов коллекции
	 */
	private int length;
	
	/**
	 * Создает заголовок из листа строк
	 *
	 * @param list лист строк
	 */
	public Header(List<String> list) {
		this.list = list;
		setSetAndLength(list);
	}
	
	/**
	 * Создает заголовок из массива строк
	 * @param array массив строк
	 */
	public Header(String[] array) {
		this(Arrays.asList(array));
	}
	
	/**
	 * Создает заголовок из массива переменных
	 * @param values массив переменных
	 */
	public Header(Variable[] values) {
		this.list = new ArrayList<>();
		for (Variable variable : values)
			this.list.add(variable.getVariableName());
		setSetAndLength(list);
	}
	
	/**
	 * Создает сет из листа строк
	 * Устанавливает количество элементов коллекции
	 *
	 * @param list лист строк
	 */
	public void setSetAndLength(List<String> list) {
		this.set = new LinkedHashSet<>(list);
		this.length = list.size();
	}
	
	/**
	 * Возвращает лист коллекции
	 *
	 * @return лист коллекции
	 */
	public List<String> getList() {
		return list;
	}
	
	/**
	 * Возвращает коллекцию конвертированную из листа в массив
	 *
	 * @return коллекцию конвертированную из листа в массив
	 */
	public String[] getArray() {
		return list.toArray(new String[list.size()]);
	}
	
	/**
	 * Возвращает сет коллекции
	 *
	 * @return сет коллекции
	 */
	public Set<String> getSet() {
		return set;
	}
	
	/**
	 * Возвращает длинну элементов коллекции
	 *
	 * @return длинну элементов коллекции
	 */
	public int getLength() {
		return length;
	}
}
