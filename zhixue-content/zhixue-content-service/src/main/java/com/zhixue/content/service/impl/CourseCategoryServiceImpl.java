package com.zhixue.content.service.impl;

import com.zhixue.content.mapper.CourseCategoryMapper;
import com.zhixue.content.model.dto.CourseCategoryTreeDto;
import com.zhixue.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {
        // 得到了根节点下边的所有子节点
        List<CourseCategoryTreeDto> categoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);
        // 定义一个 List，作为最终返回的数据
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = new ArrayList<>();
        // 为了方便找到子节点的父节点，定义一个 map
        Map<String, CourseCategoryTreeDto> nodeMap = new HashMap<>();
        // 将数据封装到 List 中，只包括了根节点的直接下属节点
        categoryTreeDtos.forEach((item) -> {
            nodeMap.put(item.getId(), item);
            if (item.getParentid().equals(id)) {
                courseCategoryTreeDtos.add(item);
            }
            // 找到该节点的父节点
            String parentid = item.getParentid();
            CourseCategoryTreeDto parentNode = nodeMap.get(parentid);
            if (parentNode != null) {
                if (parentNode.getChildrenTreeNodes() == null) {
                    parentNode.setChildrenTreeNodes(new ArrayList<>());
                }
                // 找到子节点，放到它的父节点 childrenTreeNodes 属性中
                parentNode.getChildrenTreeNodes().add(item);
            }
        });
        // 返回 list 中只包含了根节点的下属节点
        return courseCategoryTreeDtos;
    }
}
