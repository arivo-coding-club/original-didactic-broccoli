package application.model;

import java.util.LinkedList;
import java.util.Queue;

import application.exception.SlotMaxException;

public class ItemSlot {
	// 자판기 내부에 있는 음료 슬롯의 갯수
	/*
	 * 자판기를 열어보면 
	 * | A음료 슬롯 |  | B음료 슬롯 |  | C음료 슬롯 |  | D음료 슬롯 | ..
	 * 이런식으로 나뉘어져 있고, 거기에 캔이 보관되어 있음, 이 슬롯의 갯수
	 */
	private static final int SLOT_COUNT = 6;
	
	// 슬롯별 캔을 저장할 수 있는 최대 갯수
	private static final int MAX_STOCK = 10;
	
	// 슬롯의 배열
	// 슬롯은 먼저 넣은 것이 먼저 나오므로 (FIFO) 큐를 사용해서 상품을 저장
	private Queue<Item>[] slots = new Queue[SLOT_COUNT];
	
	public ItemSlot() {
		// 슬롯 배열의 큐 초기화
		for(int i = 0 ; i < slots.length ; i++) {
			slots[i] = new LinkedList<>();
		}
	}
	
	// 특정 슬롯에 재고가 있는지를 확인하는 메서드
	public boolean hasStock(int slotIndex) {
		checkSlotIndex(slotIndex);
		
		return !slots[slotIndex].isEmpty();
	}
	
	// 사용자가 상품을 선택했을 때 해당 상품의 slotIndex를 받아서 반환 
	public Item draw(int slotIndex) {
		checkSlotIndex(slotIndex);
		
		// 큐에서 상품을 뺄 때는 poll 메서드를 사용.
		// 가장 먼저 넣은 상품이 큐에서 빠져 나오고 큐의 크기는 1이 줄어듬
		return slots[slotIndex].poll();
	}
	
	// 슬롯에 상품 추가 - 관리자가 상품 재고를 채울 때 사용
	public void charge(int slotIndex, Item item) {
		checkSlotIndex(slotIndex);
		
		// 슬롯에 최대로 넣을 수 있는 상품의 수는 제한되어 있으므로 더 이상 추가할 수 없을 때는 예외 발생
		if(slots[slotIndex].size() >= MAX_STOCK) {
			throw new SlotMaxException("슬롯이 꽉 차있습니다.");
		}
		
		slots[slotIndex].add(item);
	}
	
	// 정상적인 슬롯 인덱스인지 체크하는 메서드.
	// 0~SLOT_COUNT
	private void checkSlotIndex(int slotIndex) {
		if(slotIndex >= SLOT_COUNT || slotIndex < 0) {
			throw new IllegalArgumentException("slotIndex는 SLOT_COUNT+1을 초과하거나 0보다 작을 수 없습니다. slotIndex=" + slotIndex);
		}
	}
}
