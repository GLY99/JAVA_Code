package org.example.service;

import org.example.mapper.MemberMapper;
import org.example.model.Member;
import org.example.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private SettingService settingService;

    public List<Member> queryBySettingId(Integer id) {
        return memberMapper.selectBySettingId(id);
    }

    public int add(Member member, Integer userId) {
        Setting setting = settingService.queryByUserId(userId);
        member.setSettingId(setting.getId());
        return memberMapper.insertSelective(member);
    }

    public int update(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    public int delete(Integer id) {
        return memberMapper.deleteByPrimaryKey(id);
    }
}
