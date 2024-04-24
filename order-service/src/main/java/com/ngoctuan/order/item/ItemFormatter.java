package com.ngoctuan.order.item;

import com.ngoctuan.data.entity.Item;
import com.ngoctuan.order.repository.ItemRepository;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ItemFormatter implements Formatter<Item> {

	private ItemRepository itemRepository;

	public ItemFormatter(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public String print(Item item, Locale locale) {
		return item.getItemId().toString();
	}

	@Override
	public Item parse(String text, Locale locale) throws ParseException {
		return itemRepository.findById(Long.parseLong(text)).get();
	}

}
