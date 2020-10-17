import React, {Component, useEffect, useState} from 'react';
import {useSortBy, useTable} from "react-table";
import styled from 'styled-components'


export default function Rent(props) {
    let [data, setData] = useState([])

    useEffect(() => {
        console.log("props test: " + props.id)
        if (data.length < 1) loadData()
    })

    function loadData() {
        if (props.id !== "2") {
            fetch('http://localhost:8080/rent/movielist')
                .then(response => response.json())
                .then(data => {
                    console.log("data")
                    console.log(data)
                    setData(data)
                })
                .catch((err) => {
                    console.error(this.props.url, err.toString());
                })
        }
        if (props.id === "2") {
            fetch('http://localhost:8080/rent/moviedetails')
                .then(response => response.json())
                .then(data => {
                    console.log("data 2")
                    console.log(data)
                    setData(data)
                })
                .catch((err) => {
                    console.error(this.props.url, err.toString());
                })
        }
    }

    const Styles = styled.div`
  padding: 1rem;
  table {
    border-spacing: 0;
    border: 1px solid black;
    tr {
      :last-child {
        td {
          border-bottom: 0;
        }
      }
    }
    th,
    td {
      margin: 0;
      padding: 0.5rem;
      border-bottom: 1px solid black;
      border-right: 1px solid black;
      :last-child {
        border-right: 0;
      }
    }
  }
`;

    function Table({columns, data}) {
        const {
            getTableProps,
            getTableBodyProps,
            headerGroups,
            rows,
            prepareRow,
        } = useTable(
            {
                columns,
                data,
            },
            useSortBy
        );
        const firstPageRows = rows.slice(0, 20);

        return (
            <>
                <table {...getTableProps()}>
                    <thead>
                    {headerGroups.map(headerGroup => (
                        <tr {...headerGroup.getHeaderGroupProps()}>
                            {headerGroup.headers.map(column => (
                                <th {...column.getHeaderProps(column.getSortByToggleProps())}>
                                    {column.render('Header')}
                                    {/* Add a sort direction indicator */}
                                    <span>
                    {column.isSorted
                        ? column.isSortedDesc
                            ? ' 🔽'
                            : ' 🔼'
                        : ''}
                  </span>
                                </th>
                            ))}
                        </tr>
                    ))}
                    </thead>
                    <tbody {...getTableBodyProps()}>
                    {firstPageRows.map(
                        (row, i) => {
                            prepareRow(row);
                            return (
                                <tr {...row.getRowProps()}>
                                    {row.cells.map(cell => {
                                        return (
                                            <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
                                        )
                                    })}
                                </tr>
                            )
                        }
                    )}
                    </tbody>
                </table>
                <br/>
                <div>Showing the first 20 results of {rows.length} rows</div>
            </>
        )
    }

    let columns = React.useMemo(
        () => [
            {
                Header: 'Filmy',
                showPaginationTop: true,
                showPaginationBottom: false,
                showPageSizeOption: false,
                columns: [
                    {
                        Header: 'Tytul',
                        accessor: 'original_title',
                        maxWidth: 100,
                        minWidth: 100
                    },
                    {
                        Header: 'Opis',
                        accessor: 'overview',
                        maxWidth: 100,
                        minWidth: 100
                    },
                    {
                        Header: 'Popularnosc',
                        accessor: 'popularity',
                        maxWidth: 100,
                        minWidth: 100
                    },
                ]
            },
        ],
    );

    const details = React.useMemo(
        () => [
            {
                Header: 'Filmy',
                showPaginationTop: true,
                showPaginationBottom: false,
                showPageSizeOption: false,
                columns: [
                    {
                        Header: 'Tytul',
                        accessor: 'name',
                        maxWidth: 100,
                        minWidth: 100
                    },
                    {
                        Header: 'Dostepnych',
                        accessor: 'available',
                        maxWidth: 100,
                        minWidth: 100
                    },
                    {
                        Header: 'Cena',
                        accessor: 'price',
                        maxWidth: 100,
                        minWidth: 100
                    },
                ]
            },
        ],
    );
    if (props.id !== "2") {
        return (
            <center>
                <div>
                    <Styles>
                        <Table columns={columns} data={data}/>
                    </Styles>
                </div>
            </center>
        )
    } else {
        return (
            <center>
                <div>
                    <Styles>
                        <Table columns={details} data={data}/>
                    </Styles>
                </div>
            </center>
        )
    }
}

