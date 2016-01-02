package fs.common.util;

import java.util.ArrayList;
import java.util.List;

/**List和String的转换，主要是用在玩家类的武功武器背包属性转换上
 * @author Jason_★  
 */
public class ListAndString 
{
	public static String ListToString(List<Integer> l1)
	{
		if(l1==null)
		{
			return null;
		}
		else
		{
			String s1 = "";
			for(int i=0;i<l1.size();i++)
			{
				s1=s1+l1.get(i)+",";
			}
			return s1;
		}
	}

	public static List<Integer> StringToList(String s1)
	{
		if(s1==null)
		{
			return null;
		}
		else
		{
			List<Integer> l1 = new ArrayList<Integer>();
			String s2 = "";
			for(int i=0;i<s1.length();i++)
			{
				if(s1.charAt(i)==',')
				{
					l1.add(Integer.parseInt(s2));
					s2="";
					continue;
				}
				s2=s2+s1.charAt(i);
			}
			return l1;
		}
	}
}
