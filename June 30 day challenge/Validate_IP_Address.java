class Solution
{
    public String validIPAddress(String IP)
    {
        if(IP.indexOf('.') > 0 && !IP.startsWith(".") && !IP.endsWith("."))
        {
            boolean check = true;
            String[]parts = IP.split("\\.");
            if(parts.length == 4) {
                for (String part : parts) {
                    try 
                    {
                        int num = Integer.parseInt(part);
                        if (!(num >= 0 && num <= 255) || (part.startsWith("0")&& part.length()>1)||part.startsWith("-"))
                        {
                            check = false;
                            break;
                        }
                    } catch (Exception e) {
                        check = false;
                        break;
                    }
                }
            }
            else
            {
                check=false;
            }
            if(check)
            {
                return "IPv4";
            }
        }
        if(IP.indexOf(":")>0 && !IP.startsWith(":") && !IP.endsWith(":"))
        {

            boolean check = true;
            String [] parts = IP.split(":");
            if(parts.length == 8 && !parts[0].startsWith("0"))
            {
                for (String part:parts)
                {
                    for (char ch:part.toCharArray()) {
                        if((ch >= 'G' && ch <= 'Z')||(ch>='g'&&ch<='z')||ch=='-')
                        {
                            check = false;
                            break;
                        }
                    }
                    if(part.length()>4 || part.length()==0)
                    {
                        check = false;
                        break;
                    }
                    else if(part.length()==4 || (part.length()==1 && part.charAt(0)=='0'))
                    {
                        continue;
                    }
                }
            }
            else
            {
                check=false;
            }
            if(check)
            {
                return "IPv6";
            }
        }
        return "Neither";

    }

}


