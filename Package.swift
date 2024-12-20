// swift-tools-version:5.7
import PackageDescription

// let package = Package(
//     name: "POCLib",
//     platforms: [
//         .iOS(.v13)
//     ],
//     products: [
//         .library(
//             name: "POCLib",
//             targets: ["POCLib"]
//         ),
//     ],
//     targets: [
//         .binaryTarget(
//             name: "poc_lib",
//             path: "poc-lib/build/xcframework/poc_lib.xcframework"
//         )
//     ]
// )

let package = Package(
    name: "POCLib",
    platforms: [.macOS(.v13), .iOS(.v13)],
    dependencies: [
        .package(url: "https://github.com/kneeman/POCLib.git", branch: "feautre/iOS-integration-2")
    ],
    targets: [
        .binaryTarget(
            name: "poclib",
            path: "poc-lib/build/XCFrameworks/poc_lib.xcframework"
        )
    ]
)