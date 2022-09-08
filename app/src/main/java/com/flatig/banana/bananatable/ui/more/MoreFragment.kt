package com.flatig.banana.bananatable.ui.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.flatig.banana.bananatable.R
import com.flatig.banana.bananatable.TableApplication
import com.flatig.banana.bananatable.logic.model.MoreFragCardViewData

class MoreFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var itemShow = mutableListOf(
        MoreFragCardViewData(
            TableApplication.context.resources.getString(R.string.moreItem_grades),
            R.mipmap.file_2
        ),
        MoreFragCardViewData(
            TableApplication.context.resources.getString(R.string.moreItem_exams),
            R.mipmap.file_3
        ),
        MoreFragCardViewData(
            TableApplication.context.resources.getString(R.string.moreItem_classrooms),
            R.mipmap.file_4
        )
    )
    private val itemList = ArrayList<MoreFragCardViewData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList(view)

        val layoutManager = GridLayoutManager(requireActivity(), 2)
        recyclerView.layoutManager = layoutManager
        val adapter = MoreRecyclerAdapter(requireActivity(), itemList)
        recyclerView.adapter = adapter
    }

    private fun initList(view: View) {
        recyclerView = view.findViewById(R.id.moreFrag_recyclerView)
        itemList.clear()

        for (i in (0 until itemShow.size)) itemList.add(itemShow[i])
    }
}