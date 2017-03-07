package it.unimi.dsi.fastutil.ints;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;

public class Int2IntMapTest {
	@SuppressWarnings("deprecation")
	@Test
	public void testDefaultGetOrDefault() {
		Int2IntMap m = new AbstractInt2IntMap() {
			private static final long serialVersionUID = 0L;

			@Override
			public int size() { return 1; }
			@Override
			public int get(int key) {
				return key == 1 ? 1 : 0;
			}
			
			@Override
			public ObjectSet<Entry> int2IntEntrySet() {
				return ObjectSets.singleton(new AbstractInt2IntMap.BasicEntry(1, 0));
			}
		};
		
		assertEquals(1, m.getOrDefault(0, 1));
		assertEquals(Integer.valueOf(1), m.getOrDefault(null, Integer.valueOf(1)));
		assertEquals(Integer.valueOf(1), m.getOrDefault(Integer.valueOf(0), Integer.valueOf(1)));
		assertEquals(1, m.getOrDefault(1, 2));
		assertEquals(Integer.valueOf(1), m.getOrDefault(Integer.valueOf(1), Integer.valueOf(2)));		
	}
}
