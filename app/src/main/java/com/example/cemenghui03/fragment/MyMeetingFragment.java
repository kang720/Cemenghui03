package com.example.cemenghui03.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cemenghui03.DetailActivity;
import com.example.cemenghui03.MainActivity;
import com.example.cemenghui03.R;
import com.example.cemenghui03.adpter.MeetingItemAdapter;
import com.example.cemenghui03.entity.MeetingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyMeetingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyMeetingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<MeetingBean> meetingBeanList;
    private MeetingItemAdapter meetingItemAdapter;
    private ListView listView;

    public MyMeetingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyMeetingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyMeetingFragment newInstance(String param1, String param2) {
        MyMeetingFragment fragment = new MyMeetingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_meeting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listView = view.findViewById(R.id.meeting_list);
        initData();
        meetingItemAdapter = new MeetingItemAdapter(meetingBeanList, getContext());
        listView.setAdapter(meetingItemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle=new Bundle();
                MeetingBean meetingBean=meetingBeanList.get(position);
                bundle.putString("name",meetingBean.getName());
                bundle.putString("desc",meetingBean.getDesc());
                bundle.putString("data",meetingBean.getData());
                bundle.putString("location",meetingBean.getLocation());
                bundle.putString("company",meetingBean.getCompany());
                bundle.putString("process",meetingBean.getProcess());
                bundle.putString("attendence",meetingBean.getAttendence());
                bundle.putInt("img",meetingBean.getImg());
                Intent intent=new Intent(getContext(), DetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    private void initData() {
        meetingBeanList = new ArrayList<>();
        meetingBeanList.add(new MeetingBean(
                "中国电子信息行业质量品牌大会",
                "大会将汇聚电子信息行业的领军企业、专家学者和政府代表，共同探讨行业质量与品牌发展的新趋势、新挑战和新机遇。通过主题演讲、品牌展示和圆桌论坛等形式，深入剖析行业发展现状，分享优秀企业的质量品牌建设经验，推动行业整体质量水平和品牌影响力的提升。会议将关注技术创新、市场需求和政策导向，为企业提供战略指导和实践参考，促进电子信息行业的可持续发展。",
                "2024 年 7 月 15 - 16 日",
                "深圳",
                "中国通信工业协会",
                "主题演讲、品牌展示、圆桌论坛",
                "知名企业高管张总、行业资深分析师刘先生、政府相关部门政策专家陈女士",
                R.drawable.d1));
        meetingBeanList.add(new MeetingBean(
                "用户体验提案研讨会",
                "研讨会专注于用户体验提案的方法与实践，为从事用户体验设计、研究和管理的专业人士提供一个交流和学习的平台。通过经验分享、提案展示和互动交流，参会者将了解到最新的用户体验研究方法和设计理念，掌握如何撰写高质量的用户体验提案，提升提案的说服力和可行性。会议还将探讨用户体验在不同行业的应用案例，为参会者提供实际操作的参考和借鉴。",
                "2024 年 8 月 20 - 21 日",
                "北京",
                "中国交互设计专业委员会",
                "经验分享、提案展示、互动交流",
                "用户体验专家王博士、知名互联网公司用户体验总监赵女士、独立用户体验咨询师孙先生",
                R.drawable.d2));
        meetingBeanList.add(new MeetingBean(
                "电动自行车电池高质量发展大会",
                "大会围绕电动自行车电池产业的高质量发展展开，聚焦行业热点和难点问题，邀请政府部门、科研机构、企业代表等共同参与，探讨产业政策、技术创新、安全标准等方面的发展方向。通过政策解读、技术研讨和成果发布，为企业提供政策支持和技术指导，推动电动自行车电池产业的升级和转型。会议还将关注市场需求和消费者权益，促进产业的健康、可持续发展",
                "2024 年 4 月 24 - 25 日",
                "北京",
                "中国化学与物理电源行业协会",
                "政策解读、技术研讨、成果发布",
                "行业协会领导刘主任、电池技术专家周教授、电动自行车企业研发负责人吴先生",
                R.drawable.d3));
        meetingBeanList.add(new MeetingBean(
                "中国电子质量管理协会十届二次理事会暨十届二次常务理事会",
                "这是协会内部的重要决策会议，将总结过去一段时间的工作成果，审议协会的工作计划和财务报告，讨论并决定协会的重大事项。理事会和常务理事会成员将围绕行业发展动态、协会工作重点和会员需求等方面进行深入交流和讨论，为协会的发展制定战略规划和工作方向。会议将加强协会内部的沟通与协作，提高协会的决策效率和服务水平",
                "2024 年 5 月 5 - 6 日",
                "深圳",
                "中国电子质量管理协会",
                "工作汇报、决策讨论、规划部署",
                "协会资深理事林先生、协会财务负责人郑女士、行业年轻新锐理事何先生",
                R.drawable.d4));
        meetingBeanList.add(new MeetingBean(
                "中国电子质量品牌建设高峰论坛",
                "高峰论坛聚焦电子质量品牌建设，邀请政府官员、行业领袖、专家学者等齐聚一堂，共同探讨电子质量品牌建设的理论和实践。通过主旨演讲、高端对话和成果展示，分享行业前沿观点和成功经验，分析质量品牌建设面临的挑战和机遇，提出针对性的解决方案和建议。会议将推动电子行业质量品牌建设的创新发展，提升中国电子产品的国际竞争力。",
                "2024 年 9 月 25 - 26 日",
                "杭州",
                "中国电子质量管理分会",
                "主旨演讲、高端对话、成果展示",
                "政府官员魏先生、行业领袖唐总、质量品牌研究专家蒋教授",
                R.drawable.d5));
        meetingBeanList.add(new MeetingBean(
                "可靠性应用技术国际论坛",
                "国际论坛旨在搭建一个可靠性应用技术的国际交流平台，吸引国内外知名专家、学者和企业代表参与，分享可靠性领域的最新研究成果和实践经验。通过前沿报告、技术展示和合作洽谈，探讨可靠性技术在电子、航空、汽车等多个领域的应用和发展趋势，促进可靠性技术的创新和推广。会议将加强国际间的合作与交流，推动可靠性技术的全球化发展。",
                "2024 年 10 月 18 - 19 日",
                "广州",
                "中国可靠性工程学会",
                "前沿报告、技术展示、合作洽谈",
                "国际专家学者马克博士、国内可靠性技术领军人物杨教授、企业可靠性部门负责人徐经理",
                R.drawable.d6));
        meetingBeanList.add(new MeetingBean(
                "第十二届中国用户体验大会",
                "作为国内用户体验领域的重要盛会，大会将汇聚行业精英，共同探讨用户体验设计、研究和管理的最新趋势和方法。通过主题分享、案例展示和颁奖典礼等环节，展示优秀的用户体验项目和创新实践，表彰在用户体验领域做出杰出贡献的个人和团队。会议将为行业从业者提供学习和交流的机会，推动用户体验行业的发展和进步。",
                "2024 年 11 月 2 - 3 日",
                "南京",
                "中国用户体验设计行业协会",
                "主题分享、案例展示、颁奖典礼",
                "知名企业体验官李女士、用户体验行业知名博主陈先生、高校用户体验专业导师胡教授",
                R.drawable.d7));
        meetingBeanList.add(new MeetingBean(
                "中国电子信息行业质量品牌大会",
                "大会将汇聚电子信息行业的领军企业、专家学者和政府代表，共同探讨行业质量与品牌发展的新趋势、新挑战和新机遇。通过主题演讲、品牌展示和圆桌论坛等形式，深入剖析行业发展现状，分享优秀企业的质量品牌建设经验，推动行业整体质量水平和品牌影响力的提升。会议将关注技术创新、市场需求和政策导向，为企业提供战略指导和实践参考，促进电子信息行业的可持续发展。",
                "2024 年 7 月 15 - 16 日",
                "深圳",
                "中国电子质量管理协会",
                "主题演讲、品牌展示、圆桌论坛",
                "知名企业高管张总、行业资深分析师刘先生、政府相关部门政策专家陈女士",
                R.drawable.d8));
        meetingBeanList.add(new MeetingBean(
                "《算力设施工程技术标准》编制会议",
                "大会将汇聚电子信息行业的领军企业、专家学者和政府代表，共同探讨行业质量与品牌发展的新趋势、新挑战和新机遇。通过主题演讲、品牌展示和圆桌论坛等形式，深入剖析行业发展现状，分享优秀企业的质量品牌建设经验，推动行业整体质量水平和品牌影响力的提升。会议将关注技术创新、市场需求和政策导向，为企业提供战略指导和实践参考，促进电子信息行业的可持续发展。",
                "2024 年 7 月 15 - 16 日",
                "深圳",
                "中国计算机学会高性能计算专业委员会",
                "主题演讲、品牌展示、圆桌论坛",
                "知名企业高管张总、行业资深分析师刘先生、政府相关部门政策专家陈女士",
                R.drawable.d9));
        meetingBeanList.add(new MeetingBean(
                "《用户体验智能座舱人机界面评测规范》团体标准研讨会",
                "本次培训班聚焦电子信息行业的质量管理与班组建设，旨在为行业培养一批具备专业素养和实践能力的骨干人才。通过系统的课程学习和案例分析，学员将深入了解质量管理的先进理念和方法，掌握班组建设的核心要点，提升团队协作和问题解决能力。培训内容涵盖质量管理体系、质量工具应用、班组管理技巧等多个方面，为学员提供全面的知识储备和实践经验。",
                "2024 年 6 月 10 - 12 日",
                "上海",
                "中国汽车工程学会汽车智能网联技术分会",
                "专家授课、案例分析、小组讨论",
                "行业质量专家李教授、知名企业质量管理负责人王经理、高校质量管理专业教授张博士",
                R.drawable.d10));


    }
}