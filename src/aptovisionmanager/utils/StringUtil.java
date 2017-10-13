package aptovisionmanager.utils;

public class StringUtil
{
	public static String[] getPaths(String prefix , String suffix , Integer count)
	{
		
		if(count <= 0) return null;
		
		String[] paths = new String[count];
		
		for (int i = 0; i < count; i++)
		{
			paths[i] = prefix + (i+1) + "." + suffix;
		}
						
		return paths;		
	}

}
