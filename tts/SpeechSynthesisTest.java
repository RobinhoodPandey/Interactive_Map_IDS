import com.sun.speech.freetts.*;

public class SpeechSynthesisTest
{
    public static void main(String[] args)
    {
        Voice voiceKevin16 = new Voice("kevin");
        String str="",str1="";
        for (int i = 0; i < args.length; i++)
        {
            //this.say( thingsToSay[i] );
            str=str+" "+args[i];
            //str1+=args[i];
        }
        //voiceKevin16.say("I can say it in two ways.1st very fast.");
        voiceKevin16.say(str);
        //voiceKevin16.say("and secondly very slow.word by word.");
        //voiceKevin16.say(args);
        //System.out.println(str);
        //System.out.println(str1);
    }
}

class Voice
{
    private String name;
    private com.sun.speech.freetts.Voice systemVoice;

    public Voice(String name)
    {
        this.name = name;
        this.systemVoice = VoiceManager.getInstance().getVoice(this.name);
        this.systemVoice.allocate();
    }

    public void say(String[] thingsToSay)
    {
        String str="";
        for (int i = 0; i < thingsToSay.length; i++)
        {
            this.say( thingsToSay[i] );
        }
    }

    public void say(String thingToSay)
    {
        this.systemVoice.speak(thingToSay);
    }

    public void dispose()
    {
        this.systemVoice.deallocate();
    }
}