package com.iflytek.service;

import com.iflytek.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author JinXing
 * @date 2020/6/18 21:14
 */
public class BaseSpeechServiceTest extends BaseTest {

    @Resource
    private BaseSpeechService baseSpeechService;

    @Test
    public void textToSpeech() {

        String text = getText();
        String substring = text.substring(0, 100);


        baseSpeechService.textToSpeech(substring);
    }

    /**
     * 获取解析的文本
     */
    private static String getText() {
        return "陈春花：疫情下，如何成为那个活下来的人？\n" +
                "\n" +
                "面对变化，理解“新常态”\n" +
                "\n" +
                "这是我今年第一场线下论坛，我希望所有的一切都会越来越好。\u2028\n" +
                "今天一个非常大的变化，就是全球进入“新常态”。\u2028\n" +
                "在“新常态”下，增长方式变了。以前的增长方式是用规模拉动，用出口拉动，用资源投入拉动，而现在换了一种方法，我们把这叫做“新常态”出现。换个角度说，全球的经济开始进入一种增长方式改变、增长速度下调的状态。\u2028\n" +
                "这一次的变化非常特殊。首先，这是一次左右互搏。如果想把疫情控制住，经济要停摆，如果想恢复经济，疫情可能就防控不住。任何一边处理不好，都是致命的。虽然各个地方的防控级别都在下调，但是防控上我们依旧不能松懈。这样的左右互搏会是一个相对长期的过程，这是“新常态”中很大的难题。\u2028\n" +
                "其次，全球经济衰退基本已成定局。有人问我中国经济什么时候可以恢复到正常的状态，我说如果全球的疫情没有得到完全的防控，全球的经济没恢复，中国就没有恢复。所有的经济都是一体的，不管讨不讨论全球化，它一定是一体的。\n" +
                "\n" +
                "第三，从中长期来看，全球产业链一定重新布局，它可能不再是全球布局，会变成短链的、区域布局的。\n" +
                "\n" +
                "有学者称之为有限全球化，我基本上同意这个观点。但这并不意味着在中国布局的全球产业链会离开中国，因为产业链的一个很重要的要求就是比较成本和效率，只要坚持住低成本和高效率，就不会被转移。产业链的另一个重要的东西是要靠近消费市场，中国有一个足够大的消费市场。但同时全球产业链布局也不会只留在中国，会更加多元化，会有新的布局在其他的地方。浙江在全球产业链中渗透到比较深，所以一定要去思考怎么去应对这个变化。\u2028\n" +
                "在这次疫情下，我们还看到一些企业因此变得更强大。我们看到的机会是什么？是新的技术、科技的创新、数字化的能力，它们带来新的发展可能性。\n" +
                "\n" +
                "所以对企业和个人都要有要求。从企业的角度看，肯定是先活下来，然后想办法变革自己，最后想办法创造属于你的未来，这三件事情在中长期一直都要做。那么从个人的角度，我们也必须调整，要学会与“新常态”共处，同时致力于自己的不可替代性，持续学习，获取机会，提升能力。\n" +
                "\n" +
                "调整认知，与危机共处\n" +
                "我在2月全力以赴写了一本书——《危机自救：企业逆境生存之道》，3月初快速完成上市。我写这本书的时候，告诉自己一句话“当事情飞速发生已然失去控制，唯一的方法就是自己静下来”。只有安静下来，其实才会有机会。我是一个跟企业呼吸比较近的一个学者，我必须要像企业一样思考，必须写一本书来告诉大家我们应该怎么办。\u2028\n" +
                "在这本书中，我核心讲的第一个观点就是要快速调整认知。因为在一个变化的环境里，经验的作用没有认知能力作用大。经验是从遇到的问题中积累起来的，但是在一个变化的环境下，遇到的都是从没遇到过的问题。那么在经验没用的时候，有用的就是认知能力。\n" +
                "\n" +
                "所谓认知能力，就是外部输入信息给你，你知道怎么认识它并运用它。比如我和一位企业家在疫情面前，我们的认知能力就会不一样，企业家的认知会决定他的企业的发展，我的认知会决定我写一本书。\u2028\n" +
                "我们需要调整5个认知。\u2028\n" +
                "1.与危机带来的不确定性共处\u2028\u2028就像我们要习惯戴口罩，我们要习惯人与人之间保持一定的距离，我们要习惯能够在线解决问题时不在线下去解决，核心就是改变自己。\n" +
                "\n" +
                "经历这次疫情，我们发现好像不需要那么忙活，可以跟家人多待一点，也不需要那么多的聚会，也不需要开那么多的会，一切都是可以调整的。我希望我们可以把这样的改变变成常态，可以恢复消费，推动经济，但同时也不需要恢复聚会。这是第一个认知的调整，核心要改变自己，要学会与危机带来的不确定性共处。\u2028\n" +
                "2.坚定自我发展的信心\u2028\u2028优秀管理者跟一般管理者有一个很大区别。一般的管理者行情好的时候，他做得很好，他告诉你是我做得很好，行情不好的时候他做不好，他跟你说是因为行情不好，这个叫一般管理者。优秀的管理者是行情好的时候，他告诉你这是行情带来的，和我关系不大，我运气比较好，当行情不好的时候，他也会做得很好。为什么？因为优秀的管理者在行情不好的时候有机会表现出他超越行情边界的能力。\n" +
                "\n" +
                "所以我到任何一个企业去看管理者，我基本上就是看它的发展是不是超越行情。如果不是超越行情，我就是认为他不是一个好的管理者。所以一个优秀的管理者在认知上要做到把经营条件很清楚地界定为经营条件，无论是否在危机中，绝不能变成限制条件，这样在危机中一定会找到机会，也会非常坚定发展的信心。这次疫情中，我们看到非常多的企业是力竞增长的，就是因为他们在疫情期间还是坚定地要发展，这时候他们的认知就是对的。\n" +
                "\n" +
                "3.你要学会的是不断地进化应对，而不要去预测判断\u2028\u2028在巨大的不确定性中，没有人可以预测得准。正如很多人早期就问我，到底什么时候复工？到底什么时候复产？到底什么时候复市？到底什么时候开学？……我都说我不知道。很多人会说老师你不是做研究的吗，你该知道。我说如果我说我知道，我告诉你也是骗你，因为这个病毒到现在都没人真正认识它。\n" +
                "\n" +
                "面对一个完全不认识的事物，其实你是没有办法做预测和判断的。那我们能怎么做？其实就是不断地应对，保证有动态的应对能力，而不是去想预测准确。\n" +
                "\n" +
                "4.管理者一定要管理好情绪，自我调试好心态\n" +
                "\n" +
                "管理者的心理定力其实是组织的情绪和组织的定力。一个组织有没有稳定性，由管理者决定。所以我一直要求企业家和管理者一定要自己能够调适自己的心态。你要在面对这些问题的时候，告诉自己，要以一颗平常心、同理心、积极心、信心来应对这些变化。\u2028\n" +
                "5.不确定的是环境，确定的是自己\u2028\u2028把这一点深植于企业文化的，其实是华为。华为面临来自一个强大国家的合围，但19年依然是强劲增长，2020年的第一季度业绩也还是非常好。\n" +
                "\u2028我跟任正非交流的时候，他说，美国能做什么我们不能左右，我只要把我自己做好就行。华为有一个风险管理理念，企业应该是个植物，不应该是个动物，根扎得越深，树就长得越大。不管环境好坏，都要想办法把根扎下去，吸收阳光，跟环境融为一体，长成参天大树。外边一定是不确定的，唯一能确定的就是自己得长成一棵大树。\n" +
                "\n" +
                "从生存到发展，要做5个关键行动\n" +
                "\n" +
                "当疫情变成一个全球事件的时候，我们的努力要更加长期和强劲。因此在应对此次危机的时候，必须要做5件事情。\n" +
                "1.审慎经营\n" +
                "很多人来问我，是不是抄底的机会到了？我说，在这么大的不确定面前，抄底这个词尽量不要用，因为你不知道底在哪里。这种情况下，审慎经营必然是排在第一位的。活下去靠谁？靠自己，靠非常审慎地经营。\u2028\u2028如何审慎经营，需要注意3点：\u2028\n" +
                "第一，你得有能力去贡献效率跟成本。\u2028\u2028疫情影响着全球供应需求，由此带来完全不同的供应结构与成本结构，需要企业拥有更高的效率和更低成本的能力。在需求被抑制、被伤害，整个市场恢复很困难的情况下，物美价廉绝对是核心。因为需求不会停，但购买力会改变。既然物美价廉是硬道理，如果想打硬仗，成本和效率就是核心关键。\u2028\u2028前一阵我不断被问，产业链、供应链会不会离开中国？美国出了政策，日本也出了政策，这些都是事实。但是我还是很认真说不太会，因为过去40年，我们奠定了足够的成本能力和效率水平，你只要将这两点保持住，问题就不大。\u2028\n" +
                "第二，人的生活方式改变，需要重构商业模式\u2028\u2028疫情全球防控带来的不确定性，全方位影响人们的生活并深刻改变着人们的生活方式，需要重构商业模式。你现在到线下店里去看，就会发现，虽然很多人出来消费了，但是大家还是很小心翼翼的，内心里已经埋下审慎消费的概念。所以人的生活方式改，商业模式就会调。\u2028\n" +
                "第三，重构价值体系\u2028\u2028这次巨大的变化我称之为“当下的冲击“，是一种超越传统认知的存在，需要重构价值体系。我们以前会说一件事的影响会持续一段时间，而现下这种影响是立竿见影的，直接就是停摆，直接就是物理隔离，所有人之间的交往直接被调整。它意味着我们很多价值都会被重构，这种价值重构其实就是认知上的一个调整，要超越传统认知。\u2028\n" +
                "要做好审慎经营，要做好打硬仗的准备，这三点一定要认真对待。\u2028\u2028在审慎经营上我给的行动建议就是夯实基础强化内功。\n" +
                "2.以当期经营为主，永远都要平衡当期跟长期\n" +
                "我自己辅导企业也好，我自己去做企业也好，我都给自己一个明确的要求，就是当期和长期的平衡。“我们要以当期经营为主”这句话如果放在疫情前，放在我们的新经济高速增长的时候，我可能会告诉你要以更多的力量布局长期。但在“新常态”下，一定以当期经营为主，然后再来平衡当期和长期。\u2028\n" +
                "我们靠什么来以当期经营为主？就做两件事情：\u2028\n" +
                "第一件事情，一定要比别人更努力，以不亚于任何人的努力改造你的当期业务。\u2028\n" +
                "举个小的例子，在第一季度汽车行业整体份额下滑时候，一个专门供应高端车零部件的汽车零部件供应商，发现下滑的百分之四十几份额是高端车，然而低端车反而需求量上涨。于是他以最快的速度要求研发部门、制造部门整体去做调整，以最短的时间以高端车供应部件的品质供应低端车，但是价格大幅下滑10%。做了5个方向的创新和结构的调整后，它竟然比去年同期的订单增加了50%。\u2028\n" +
                "所以并不是没有机会，你一定要以不亚于任何人的努力来解决你的当期业务。当期业务中，很多成本是可以调整的。我在我的课程中讲过，我们的成本有非常多的浪费构成，你只要认真去做，你一定是可以找出空间来。\u2028\n" +
                "第二件事情，关注当期业绩\u2028\n" +
                "当期的业绩最主要靠两个东西：一个是整个组织系统的效率，一个是能跟顾客去沟通。如果你能够去调整你的组织效率，如果你愿意去跟顾客直接做沟通，那你的当期业务就可以获得。\u2028\n" +
                "在讲以当期经营为主的时候，我就给你这两个建议，但是我们依然不会放弃长期，任何一个企业经营都是当期与长期平衡。\n" +
                "那我们长期怎么做？开放你的组织去做一些布局，然后你才能够找到一些新的可能性。\n" +
                "总而言之，把当下做好，你做好当下你就会有未来。\n" +
                "\n" +
                "3.有能力的企业，要关注产业伙伴与价值伙伴的共生\n" +
                "\n" +
                "在这样大的疫情冲击下，非常多的中小企业是非常艰难的，但我们一定要懂一件事情，任何一个企业都不能独立于产业链活下来。\n" +
                "我在04年的时候写过一本书，叫做《争夺价值链》。那时我就坚定了一个认知：不是企业跟企业竞争，其实是价值链跟价值链竞争。所以如果你有能力让整条价值链活下来，基本上大家都可以活下来。如果整个价值链死掉，独独一家企业是活不了的。当然我们现在已经称之为生态链了。\n" +
                "我对复工复产不特别担心，因为我们的企业家们都会非常努力做这件事情，我最担心的是市场如何恢复，在防控下怎么让市场活跃、让消费活跃，其实这是根本需要解决的问题。只有真正的市场活跃、消费活跃，我们才可以拉动整个产业。所以这其实是一个生态氛围。\u2028\n" +
                "在我过去30年研究当中，有一条线就是专门研究那些活过50年、100年、200年的企业，它们在生存下来的过程中一定是经过一些危机的检验的。\n" +
                "中国企业没有经历过特大危机的检验，过去40年我们都是增长的环境，这一次开始遇到负增长，这是个检验自我的机会，如果在这一次检验中能够熬过去，那算是第一次接受了彻底的检验。\n" +
                "在过去的历史中，我们会看到那些真正经历过特殊危机环境还可以涨的企业还是很多的，原因是什么？其实就是生态伙伴、价值伙伴的共生。美国走出“大萧条”，大家都讲是因为罗斯福新政，但是其中还有一个很重要的运动叫蓝鹰运动。当时有250万家企业参与蓝鹰运动，不裁员，坚定经营。\n" +
                "我为什么对中小企业这么在意，因为如果中小企业都活下来，我们的失业率就会下来，那我们才会真正有机会走出经济的衰退。当然如果你的能力没那么大，那还是专注于让自己先活下来，但一旦你有能力，我希望你尽可能让你的生态伙伴活下来。因为一棵大树是很难活的，它必须是个森林。\n" +
                "\n" +
                "4.在线、数字化是一个必选项\n" +
                "\n" +
                "我大概是在学界比较早不断地鼓励大家数字化转型的人，我自己也在2013年重回企业去带企业整体转型。\n" +
                "\n" +
                "杭州是个特殊的地方，因为杭州引领了中国消费和零售领域的在线化、数字化。曾经电子商务数字技术刚起来的时候，非常多制造业都很紧张，对虚体冲击实体的讨论很厉害。\n" +
                "\n" +
                "那时有人来问我怎么看待时，我的答案跟很多人不一样，我不认为虚体经济会冲击实体经济。因为这是两个技术、两个世界的融合，不是谁冲击谁，而是必须融合。\n" +
                "\n" +
                "为什么必须融合？原因在于技术帮助我们拓展了更大的空间。原来我们只有一个线下的世界，现在我们又多了一个线上的世界。这次的疫情最明显的特征就是线下的物理世界停摆，线上的数字世界非常丰富活跃。所以你就会发现在线化、数字化是一个必选项，不管你做什么行业都得接受。\u2028\n" +
                "在这次零售业冲击热别大的情况下，有一家企业做得很好，就是天虹百货。它的业绩比去年同期涨，原因就是它第一个做直播导购，并且让所有的人都可以去做直播导购，它也是第一个让所有的店全部去做物流配送。别人都不能做事的时候，它们能做，订单就很多，多到公司所有高管和中层管理人员全部变成快递员。这就是数字化的改变。\n" +
                "\n" +
                "疫情间所有大学都能开学，原因是什么？就是有一些能够提供在线大学的平台在帮我们，就像智慧树这家公司，它可以让非常多大学同时开学。今天你会发现，在线下解决不了的问题，在线上都可以帮你解决。\u2028\n" +
                "在一次连线访问中，我被问到如果让我去一家很小的餐馆当老板，我怎么办。我说如果是个很小的餐馆就非常好办，我就找两个快递小哥，跟他签好合约，让他全力以赴只送我这家店。然后我只服务20家，天天给他们送餐，我觉得这样我应该就可以活下来。\n" +
                "\n" +
                "疫情期间所有隔离在家的人最大的难题就是做饭，虽然做饭可以增加感情，其实也增加痛苦。不是说愿不愿意做，而是做不出花样。如果有个餐馆按家庭套餐定制给你天天送，而且比自己做便宜，我觉得这个餐馆一定能活下去。\n" +
                "\n" +
                "为什么这么多做堂食的餐馆都关掉了，就是没有能力线上化，菜还是好吃的，在家也是想吃的，但是你要能和顾客对接上，你一定要有能力去做线上交流。如果你还不具备数字化能力的话，在新常态下你会被淘汰，数字化能力已经是基本生存能力。\n" +
                "\n" +
                "5.企业家的经营意志力\n" +
                "\n" +
                "越是在非常困难的情况下就越要靠企业家的经营意志力，靠企业家精神。无论是我在08年金融危机时为企业家写的《冬天的作为》，还是这一次疫情期间写的《危机自救》，我最后都是写经营的意志力，在危机中企业家一定要成为真正的领导者。\u2028\n" +
                "即使今天个体很强大，员工很重要，但我在组织研究的范畴中还是要告诉大家领导者更重要，因为在危机当中企业家是指南针，他能告诉人们方向在哪里，他能够让人们有依靠，这个非常关键。\n" +
                "我一直研究企业成长，我们在任何危机下都看到成长的公司，其实就是由管理者的态度决定。最近一段时间，非常多的企业家去做直播，大家还在PK谁卖得多谁卖得少，我觉得所有做这些评估的人都是错的，只要企业家肯上去做直播，就是对的，不存在多与少的问题。为什么？因为这个行动才是最关键的，它会给员工信心，也会给大家帮助。所以最后问题的焦点都会落在领导者身上。\n" +
                "\n" +
                "如果我们想在后疫情时代真正能够获取发展的机会，我希望你能够认真做这5件事情。\n" +
                "\n" +
                "共生协同，是一种生存选择方式\n" +
                "\n" +
                "2019年年底我为2020年写新年寄语，当时我用了一个词“涅槃时刻”。我那时候不知道会面临这场危机，但即使没有疫情，其他的冲击也会来，因为这个时代的确就是一个巨变的不确定的时代。\u2028\n" +
                "在这个巨变的时代中，我们每个人都至少要做四件事情。\u2028\n" +
                "第一，挑战自己，方有未来。\n" +
                "\n" +
                "因为基于过去的认知，你走不到未来。我在过去两三年中讲得最多的一句话，就是“沿着旧地图找不到新大陆”。像我们做老师的，我们过去的认知都是在线下上课，我们如果只能上线下课，这一次就全覆灭。我们虽然被逼全部改成线上课，但是如果老师们不喜欢线上课，还是在基于过去的认知，是走不到未来的。\u2028\n" +
                "第二，做好自己，方可共生。\u2028\n" +
                "一定要记住，我们在今天一定是共生的方式。不管中美之间是什么样的摩擦，有一个根本的事实，就是我们必须共生协同。如果你不能够做好自己，别人就不会跟你共生。你一定要把自己做好，你就会有机会。\u2028\n" +
                "第三，先有利他，方能利己。\n" +
                "\u2028在这个疫情当中我们每个人最大的感受是什么？就是息息相关。彼此的关联是非常非常密切的，没有一个人可以是旁观者，没有一个人可以独善其身。你一定要想办法告诉自己，只有利他才会利己。我比较早讨论这个观点的时候，我们学界跟我的争论比较多，我们学界就说人本是自私的，怎么可能先利他呢？我说正是因为人本是自私的，所以他才必须理解为自己也必须利他，然后你才可以存活，因为没有人可以独善其身。\u2028\n" +
                "第四，这是结束，这是开始。\n" +
                "\n" +
                "我觉得疫情期间用这句话更恰当，我们今天所有的东西在疫情之下好像结束了，但是在疫情结束的时候，其实所有东西重新开始。你如果懂这个道理，你根本不用太担心。我前段时间被访问，问我如何看后疫情期中小企业的机会，我说，即使在疫情下，看最近的数据，除了中心城市像上海、北京、深圳、广州这些比较严控的地方，其他地方市场的恢复已经接近80%了。这么高的一个恢复量，就等于我们很多企业是有机会的。这是结束，也是开始。\n" +
                "\n" +
                "我最后我用一句话来结束今天的交流，那些真正活在未来的人，其实只做了一件事情，就是跟他自己的心，跟现在的自己作斗争。只要能够不断地跟现在的自己做斗争，其实就有机会活在未来。";
    }

}