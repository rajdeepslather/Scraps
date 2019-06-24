package assignment;

import java.util.Comparator;

public class CompareTry implements Comparable<CompareTry>
	{

	@Override
	public int compareTo(CompareTry o)
		{
		// TODO Auto-generated method stub
		return 0;
		}

	class ReverseComparator<T extends Comparable<? super T>> implements Comparator<T>
		{
		@Override
		public int compare(T o1, T o2)
			{
			return o2.compareTo(o1);
			}
		}

	public static void main(String[] args)
		{
		// CompareTry ct = new CompareTry();
		// ReverseComparator<Comparator> rc = CompareTry.ReverseComparator<Comparator>;
		}

	}
